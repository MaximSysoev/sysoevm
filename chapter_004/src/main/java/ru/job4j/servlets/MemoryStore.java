package ru.job4j.servlets;

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
                userStore.get(i).setName(user.getName());
                userStore.get(i).setLogin(user.getLogin());
                userStore.get(i).setEmail(user.getEmail());
                userStore.get(i).setCreateDate(user.createDate);
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < userStore.size(); i++) {
            if (id == userStore.get(i).getId()) {
                userStore.get(i).setName(null);
                userStore.get(i).setLogin(null);
                userStore.get(i).setEmail(null);
                userStore.get(i).setCreateDate(null);
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
                user.setLogin(u.getLogin());
                user.setName(u.getName());
                user.setEmail(u.getEmail());
                user.setCreateDate(u.getCreateDate());
            }
        }
        return user;
    }
}
