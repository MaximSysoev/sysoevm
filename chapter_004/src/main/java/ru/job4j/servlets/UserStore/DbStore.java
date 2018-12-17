package ru.job4j.servlets.UserStore;
import org.apache.commons.dbcp2.BasicDataSource;
import ru.job4j.servlets.UserStore.Store;
import ru.job4j.servlets.UserStore.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DbStore implements Store {
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static DbStore INSTANCE = new DbStore();
    private AtomicInteger id = new AtomicInteger(0);

    public DbStore() {
        SOURCE.setDriverClassName("org.postgresql.Driver");
        SOURCE.setUrl("jdbc:postgresql://localhost:5432/postgres");
        SOURCE.setUsername("postgres");
        SOURCE.setPassword("password");
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
    }

    public static DbStore getInstance() {
        return INSTANCE;
    }

    @Override
    public void add(User user) {
        System.out.println(user);
        try {
            Connection connection = SOURCE.getConnection();
 /*           Statement st = connection.prepareStatement("INSERT INTO users(id, name, login, email) values(?,?,?,?)" );
            ((PreparedStatement) st).setInt(1, id.getAndIncrement());
            ((PreparedStatement) st).setString(2, user.getName());
            ((PreparedStatement) st).setString(3, user.getLogin());
            ((PreparedStatement) st).setString(4, user.getEmail());
            ((PreparedStatement) st).executeQuery();
            st.close();
            */
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, User user) {

    }

    @Override
    public void delete(int key) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(int key) {
        return null;
    }
}