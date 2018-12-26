package ru.job4j.servlets.userstore;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;


public final class ValidateService {

    private static ValidateService instance = null;
    // public MemoryStore store = MemoryStore.getInstance();
    private final Store store = DbStore.getInstance();
    private static final Connect conn = new Connect();


    private ValidateService() {

    }

    public static synchronized ValidateService getInstance() {
        if (instance == null) {
            instance = new ValidateService();
        }
        return instance;
    }

    public boolean contain(User user) {
        return store.contain(user);
    }

    public void add(User user) {
        store.add(user);
    }

    public void update(int id, User user) {
        store.update(id, user);
    }

    public void delete(int key) {
        store.delete(key);
    }

    public List<User> findAll() {
        return  store.findAll();
    }

    public User findById(int id) {
        return store.findById(id);
    }
}