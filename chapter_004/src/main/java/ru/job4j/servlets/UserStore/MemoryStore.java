package ru.job4j.servlets.UserStore;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MemoryStore implements Store {

    private static MemoryStore _instance = null;

    public MemoryStore() {}

    public static synchronized MemoryStore getInstance() {
        if (_instance == null)
            _instance = new MemoryStore();
        return _instance;
    }

    private AtomicInteger id = new AtomicInteger(0);
    public  List<User> userStore = new CopyOnWriteArrayList<User>();

    @Override
    public void add(User user) {
        user.setId(id.getAndIncrement());
        userStore.add(user);
    }

    @Override
    public void update(int id, User user) {
        for (int i = 0; i < userStore.size(); i++) {
            if (id == userStore.get(i).getId()) {
                userStore.set(i, user);
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < userStore.size(); i++) {
            if (id == userStore.get(i).getId()) {
                userStore.remove(i);
                break;
            }
        }
    }

    @Override
    public List<User> findAll() {
        return userStore;
    }

    @Override
    public User findById(int id) {
        User user = new User();
        for (User u : this.userStore) {
            if (id == u.getId()) {
                user = u;
                break;
            }
        }
        return user;
    }
}
