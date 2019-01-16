package ru.job4j.servlets.userstore;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DbStore implements Store, AutoCloseable {

    private static DbStore instance = new DbStore();

    public static DbStore getInstance() {
        return instance;
    }

    private DbStore() {
        connection();
    }

    @Override
    public void close() throws Exception {
        source.close();
    }

    private BasicDataSource source;

    public void connection() {
        this.source = new Connect().getSOURCE();
        try (
              PreparedStatement st1 = source.getConnection().prepareStatement("create table if not exists public.roles(id serial primary key, name varchar(100))");
              PreparedStatement st2 = source.getConnection().prepareStatement("create table if not exists public.users(id serial primary key, name varchar(100), login varchar(100), email varchar (100), password varchar(100), roles_id int references roles(id))");
              PreparedStatement st3 = source.getConnection().prepareStatement("INSERT INTO users(login, password, roles_id) SELECT * FROM (SELECT 'admin', 'password', 1) as us WHERE NOT EXISTS (SELECT * FROM users WHERE login = 'admin') LIMIT 1");
              PreparedStatement st4 = source.getConnection().prepareStatement("INSERT INTO roles(name) SELECT * FROM (SELECT 'admin') as rl WHERE NOT EXISTS (SELECT * FROM roles WHERE name = 'admin') LIMIT 1");
              PreparedStatement st5 = source.getConnection().prepareStatement("INSERT INTO roles(name) SELECT * FROM (SELECT 'user') as rl WHERE NOT EXISTS (SELECT * FROM roles WHERE name = 'user') LIMIT 1");
        ) {
            st1.executeUpdate();
            st2.executeUpdate();
            st3.executeUpdate();
            st4.executeUpdate();
            st5.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean isCredentional(String login, String password) {
        boolean exists = false;
        try(PreparedStatement st = source.getConnection().prepareStatement("select * from users where login = ? and password = ?")) {
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
        try  (PreparedStatement st = source.getConnection().prepareStatement("select login, email from users where login = ? or email = ?")) {
            st.setString(1, user.getLogin());
            st.setString(2, user.getEmail());
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
        try (PreparedStatement st = source.getConnection().prepareStatement("INSERT INTO users(name, login, email, password, roles_id) values(?,?,?,?,?)")) {
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
        try (PreparedStatement st = source.getConnection().prepareStatement("UPDATE users SET name=?, login=?, email=?, password = ?, roles_id=? WHERE id=?")) {
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
        try (PreparedStatement st = source.getConnection().prepareStatement("delete from users where id = key")) {
            st.setInt(1, key);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        List<User> userStore = new CopyOnWriteArrayList<User>();
        try (PreparedStatement st = source.getConnection().prepareStatement("select * from users")) {
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
        try (PreparedStatement st = source.getConnection().prepareStatement("select * from roles")) {
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
        try (PreparedStatement st = source.getConnection().prepareStatement("select * from users where id = ?")) {
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
        try (PreparedStatement st = source.getConnection().prepareStatement("select * from users where login = ?")) {
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