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

    private Connection connection() {
        Connection connection = null;
        try {
            connection = new Connect().getSOURCE().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PreparedStatement st = connection.prepareStatement("create table if not exists public.users(id serial primary key, name varchar(100), login varchar(100), email varchar (100))")) {
            st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    @Override
    public void add(User user) {
        try (PreparedStatement st = connection().prepareStatement("INSERT INTO users(name, login, email) values(?,?,?)")) {
            st.setString(1, user.getName());
            st.setString(2, user.getLogin());
            st.setString(3, user.getEmail());
            st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, User user) {
        try (PreparedStatement st = connection().prepareStatement("UPDATE users SET name='"+user.getName()+"', login='"+user.getLogin()+"', email='"+user.getEmail()+"' WHERE id='"+id+"'")) {
            st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int key) {
        try (PreparedStatement st = connection().prepareStatement("delete from users where id = '"+key+"'")) {
            st.executeQuery();
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
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("login"), rs.getString("email"), new Date());
                userStore.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userStore;
    }

    @Override
    public User findById(int key) {
        User user = new User();
        try (PreparedStatement st = connection().prepareStatement("select * from users where id = " + key)) {
            ResultSet rs = st.executeQuery();
            rs.next();
            user.setName(rs.getString("name"));
            user.setLogin(rs.getString("login"));
            user.setEmail(rs.getString("email"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}