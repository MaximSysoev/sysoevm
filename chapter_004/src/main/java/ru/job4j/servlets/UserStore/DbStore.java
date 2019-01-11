package ru.job4j.servlets.userstore;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DbStore implements Store {
    private static DbStore instance = new DbStore();

    public static DbStore getInstance() {
        return instance;
    }

    public Connection connection() {
        Connection connection = null;
        try {
            connection = new Connect().getSOURCE().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try(PreparedStatement st = connection.prepareStatement("create table if not exists public.roles(id serial primary key, name varchar(100))")) {
            st.executeQuery();
        } catch(Exception e) {
            e.printStackTrace();
        }

        try (PreparedStatement st = connection.prepareStatement("create table if not exists public.users(id serial primary key, name varchar(100), login varchar(100), email varchar (100), password varchar(100), roles_id int references roles(id))")) {
            st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try(PreparedStatement st = connection.prepareStatement("INSERT INTO users(login, password, roles_id) SELECT * FROM (SELECT 'admin', 'password', 1) as us WHERE NOT EXISTS (SELECT * FROM users WHERE login = 'admin') LIMIT 1")) {
            st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try(PreparedStatement st = connection.prepareStatement("INSERT INTO roles(name) SELECT * FROM (SELECT 'admin') as rl WHERE NOT EXISTS (SELECT * FROM roles WHERE name = 'admin') LIMIT 1")) {
            st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try(PreparedStatement st = connection.prepareStatement("INSERT INTO roles(name) SELECT * FROM (SELECT 'user') as rl WHERE NOT EXISTS (SELECT * FROM roles WHERE name = 'user') LIMIT 1")) {
            st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public boolean isCredentional(String login, String password) {
        boolean exists = false;
        try(PreparedStatement st = connection().prepareStatement("select * from users where login = '"+login+"' and password = '"+password+"'")) {
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
        try  (PreparedStatement st = connection().prepareStatement("select login, email from users where login='"+user.getLogin()+"' or email = '"+user.getEmail()+"'")) {
            ResultSet rs = st.executeQuery();
            if (rs.next() || user.getName().isEmpty() || user.getLogin().isEmpty() || user.getEmail().isEmpty()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void add(User user) {
        try (PreparedStatement st = connection().prepareStatement("INSERT INTO users(name, login, email, password, roles_id) values(?,?,?,?,?)")) {
            st.setString(1, user.getName());
            st.setString(2, user.getLogin());
            st.setString(3, user.getEmail());
            st.setString(4, user.getPassword());
            st.setInt(5, user.getRole());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, User user) {
        try (PreparedStatement st = connection().prepareStatement("UPDATE users SET name='"+user.getName()+"', login='"+user.getLogin()+"', email='"+user.getEmail()+"', password = '"+user.getPassword()+"', roles_id='"+user.getRole()+"' WHERE id='"+id+"'")) {
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int key) {
        try (PreparedStatement st = connection().prepareStatement("delete from users where id = '"+key+"'")) {
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        List<User> userStore = new CopyOnWriteArrayList<User>();
        try (PreparedStatement st = connection().prepareStatement("select * from users")) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("login"), rs.getString("email"), new Date(), rs.getString("password"), rs.getInt("roles_id"));
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
        try (PreparedStatement st = connection().prepareStatement("select * from roles")) {
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
        try (PreparedStatement st = connection().prepareStatement("select * from users where id = '"+key+"'")) {
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
        try (PreparedStatement st = connection().prepareStatement("select * from users where login = '"+login+"'")) {
            ResultSet rs = st.executeQuery();
            rs.next();
            id = rs.getInt("roles_id");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}