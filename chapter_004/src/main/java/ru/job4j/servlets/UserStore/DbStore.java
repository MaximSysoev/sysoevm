package ru.job4j.servlets.userstore;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DbStore implements Store, AutoCloseable {

    private static DbStore instance = new DbStore();

    public static DbStore getInstance() {
        return instance;
    }

    private BasicDataSource source;

    public DbStore() {
        this.source = new BasicDataSource();
        source.setDriverClassName("org.postgresql.Driver");
        source.setUrl("jdbc:postgresql://localhost:5432/postgres");
        source.setUsername("postgres");
        source.setPassword("password");
        source.setMinIdle(5);
        source.setMaxIdle(10);
        source.setMaxOpenPreparedStatements(100);
        createTables();
        if (isEmpty()) {
            addRootUser();
        }
    }

    public void createTables() {
        try (Connection connection = source.getConnection()) {
            PreparedStatement st1 = connection.prepareStatement("create table if not exists public.roles(id serial primary key, name varchar(100))");
            PreparedStatement st2 = connection
                    .prepareStatement("create table if not exists public.users(" +
                            "id serial primary key, name varchar(100), login varchar(100)," +
                            "email varchar (100), password varchar(100)," +
                            "country varchar (100), city varchar(100),"+
                            "roles_id int references roles(id))");
            st1.execute();
            st2.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isEmpty() {
        int count = 0;
        boolean result = false;
        try (Connection connection = source.getConnection();
             PreparedStatement ps = connection.prepareStatement("Select count(*) from users")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
                if (count == 0) {
                    result = true;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void addRootUser() {
        try (Connection connection = source.getConnection()) {
            final PreparedStatement ps = connection.prepareStatement("INSERT INTO roles(name) values ('admin')");
            PreparedStatement st2 = connection.prepareStatement("INSERT INTO roles(name) values ('user')");
            PreparedStatement st3 = connection.prepareStatement("INSERT INTO users(login, password, roles_id) VALUES ('admin', 'admin', 1)");
            ps.execute();
            st2.execute();
            st3.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            source.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public boolean isCredentional(String login, String password) {
        boolean exists = false;
        try(Connection connection = source.getConnection()) {
            PreparedStatement st = connection.prepareStatement("select * from users where login = ? and password = ?");
            st.setString(1, login);
            st.setString(2, password);
            if (st.executeQuery().next()) {
                exists = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exists;
    }

    @Override
    public boolean contain(User user) {
        try  (Connection connection = source.getConnection()) {
            PreparedStatement st = connection.prepareStatement("select login, email from users where login = ? or email = ?");
            st.setString(1, user.getLogin());
            st.setString(2, user.getEmail());
            ResultSet rs = st.executeQuery();

            User uDb = null;
            if (rs.next()) {
                final String login = rs.getString("login");
                final String email = rs.getString("email");
                uDb = new User(0, "test", login, email, new Date(), "test", "", "", 1);
            }

            if (uDb!=null) {
                if (user.getEmail().equals(uDb.getEmail()) || user.getLogin().equals(uDb.getLogin())) {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void add(User user) {
        try (Connection connection = source.getConnection()) {
            PreparedStatement st = connection.prepareStatement("INSERT INTO users(name, login, email, password, roles_id, country, city) values(?,?,?,?,?,?,?)");
            st.setString(1, user.getName());
            st.setString(2, user.getLogin());
            st.setString(3, user.getEmail());
            st.setString(4, user.getPassword());
            st.setInt(5, user.getRole());
            st.setString(6, user.getCountry());
            st.setString(7, user.getCity());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, User user) {
        try (Connection connection = source.getConnection()) {
            PreparedStatement st = connection.prepareStatement("UPDATE users SET name=?, login=?, email=?, password = ?, roles_id=? WHERE id=?");
            st.setString(1, user.getName());
            st.setString(2, user.getLogin());
            st.setString(3, user.getEmail());
            st.setString(4, user.getPassword());
            st.setInt(5, user.getRole());
            st.setInt(6, id);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int key) {
        try (Connection connection = source.getConnection()) {
            PreparedStatement st = connection.prepareStatement("delete from users where id = ?");
            st.setInt(1, key);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        List<User> userStore = new CopyOnWriteArrayList<User>();
        try (Connection connection = source.getConnection()) {
            PreparedStatement st = connection.prepareStatement("select * from users");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("login"), rs.getString("email"), new Date(), rs.getString("password"), "", "", rs.getInt("roles_id"));
                userStore.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userStore;
    }

    @Override
    public List<Role> findAllRoles() {
        List<Role> roleStore = new CopyOnWriteArrayList<Role>();
        try (Connection connection = source.getConnection()) {
            PreparedStatement st = connection.prepareStatement("select * from roles");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Role role = new Role(rs.getInt("id"), rs.getString("name"));
                roleStore.add(role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roleStore;
    }

    @Override
    public User findById(int key) {
        User user = new User();
        try (Connection connection = source.getConnection()) {
            PreparedStatement st = connection.prepareStatement("select * from users where id = ?");
            st.setInt(1, key);
            ResultSet rs = st.executeQuery();
            rs.next();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setLogin(rs.getString("login"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getInt("roles_id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int findByLogin(String login) {
        int id = 0;
        try (Connection connection = source.getConnection()) {
            PreparedStatement st = connection.prepareStatement("select * from users where login = ?");
            st.setString(1, login);
            ResultSet rs = st.executeQuery();
            rs.next();
            id = rs.getInt("roles_id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}