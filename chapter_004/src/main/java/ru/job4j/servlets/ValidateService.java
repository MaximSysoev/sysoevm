package ru.job4j.servlets;
import java.util.List;

public final class ValidateService implements Store {

    private static ValidateService _instance = null;
    public MemoryStore store = new MemoryStore();

    public ValidateService() {}

    public static synchronized ValidateService getInstance() {
        if (_instance == null)
            _instance = new ValidateService();
        return _instance;
    }

    private boolean contain (User user) {
        for (int i = 0; i < store.userStore.size(); i++) {
            if (store.userStore.get(i).name.equals(user.name)) {
                return true;
            }
        }
        return false;
    }

    public void add (User user) {
        if (!contain(user)) {
            store.userStore.add(user);
        }
    }

    public void update (int id, User user) {
        store.userStore.set(id, user);
    }

    public void delete (int key) {
        this.store.userStore.remove(key);
    }

    public List<User> findAll() {
        return  this.store.userStore;
    }

    public User findById(int key) {
        int index = 0;
        User user = new User();
        for (User u : this.store.userStore) {
            if (this.store.userStore.get(index).id == key) {
                user = this.store.userStore.get(index);
                break;
            }
        }
        return user;
    }
}
