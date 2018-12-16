package ru.job4j.servlets.UserStore;
import java.util.List;

public final class ValidateService {

    private static ValidateService _instance = null;
    public MemoryStore store = MemoryStore.getInstance();
  //  private final Store store = ru.job4j.servlets.DbStore.getInstance();


    private ValidateService() {}

    public static synchronized ValidateService getInstance() {
        if (_instance == null)
            _instance = new ValidateService();
        return _instance;
    }

    public boolean contain (User user) {
        for (int i = 0; i < store.userStore.size(); i++) {
            if (store.userStore.get(i).getName().equals(user.getName()) || store.userStore.get(i).getEmail().equals(user.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public void add (User user) {
        if (!user.getName().isEmpty() && !user.getEmail().isEmpty() && !user.getLogin().isEmpty()) {
            if (!contain(user)) {
                store.add(user);
            }
        }
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

    public User findById(int id) {
        return store.findById(id);
    }
}