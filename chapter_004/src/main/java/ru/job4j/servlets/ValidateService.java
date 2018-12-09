package ru.job4j.servlets;
import java.util.List;
import java.util.Optional;

public final class ValidateService {

    private static ValidateService _instance = null;
    public MemoryStore store = MemoryStore.getInstance();

    private ValidateService() {}

    public static synchronized ValidateService getInstance() {
        if (_instance == null)
            _instance = new ValidateService();
        return _instance;
    }

    public Optional add (User user) {
        Optional result;
        if (!user.getName().isEmpty() && !user.getEmail().isEmpty() && !user.getLogin().isEmpty()) {
            store.add(user);
            result = Optional.of("user was save with id " + user.getId());
        } else {
            result = Optional.of("fields can not be empty");
        }
        return result;
    }

    public void update (int id, User user) {
        store.update(id, user);
    }

    public void delete (int key) {
        store.delete(key);
    }

    public List<User> findAll() {
        return  store.findAll();
    }

    public User findById(int key) {
        return store.findById(key);
    }
}
