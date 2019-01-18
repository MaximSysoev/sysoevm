package ru.job4j.servlets.userstore;
import java.util.List;



public final class ValidateService {

    private static ValidateService instance = null;
    private final Store store = DbStore.getInstance();


    private ValidateService() {}

    public static synchronized ValidateService getInstance() {
        if (instance == null) {
            instance = new ValidateService();
        }
        return instance;
    }

    public void close() {
        store.close();
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

    public List<Role> findAllRoles() {
        return store.findAllRoles();
    }

    public User findById(int id) {
        return store.findById(id);
    }

    public int findByLogin(String login) {
        return store.findByLogin(login);
    }
}