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
    private static Connect conn = new Connect();

    public static DbStore getInstance() {
        return instance;
    }

    @Override
    public void add(User user) {
        try {
            Connection connection = conn.getSOURCE().getConnection();
            Statement st = connection.prepareStatement("INSERT INTO users(name, login, email) values(?,?,?)");
            ((PreparedStatement) st).setString(1, user.getName());
            ((PreparedStatement) st).setString(2, user.getLogin());
            ((PreparedStatement) st).setString(3, user.getEmail());
            ((PreparedStatement) st).executeQuery();
            st.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, User user) {
        try {
            Connection connection = conn.getSOURCE().getConnection();
            Statement st = connection.prepareStatement("UPDATE users SET name='"+user.getName()+"', login='"+user.getLogin()+"', email='"+user.getEmail()+"' WHERE id='"+id+"'");
            ((PreparedStatement) st).executeQuery();
            st.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int key) {
        try {
            Connection connection = conn.getSOURCE().getConnection();
            Statement st = connection.prepareStatement("delete from users where id = '"+key+"'");
            ((PreparedStatement) st).executeQuery();
            st.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        List<User> userStore = new CopyOnWriteArrayList<User>();
        try {
            Connection connection = conn.getSOURCE().getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from users");
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("login"), rs.getString("email"), new Date());
                userStore.add(user);
            }
            st.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userStore;
    }

    @Override
    public User findById(int key) {
        User user = new User();
        try {
            Connection connection = conn.getSOURCE().getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from users where id = " + key);
            rs.next();
            user.setName(rs.getString("name"));
            user.setLogin(rs.getString("login"));
            user.setEmail(rs.getString("email"));
            st.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}