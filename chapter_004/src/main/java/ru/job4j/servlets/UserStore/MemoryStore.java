package ru.job4j.servlets.userstore;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MemoryStore implements Store {

    private static MemoryStore instance = null;

    private AtomicInteger id = new AtomicInteger(0);
    public  List<User> userStore = new CopyOnWriteArrayList<User>();

    public MemoryStore() {

    }

    @Override
    public boolean contain(User user) {
        boolean result = false;
        for (int i = 0; i < userStore.size(); i++) {
            if (user.getLogin().equals(userStore.get(i)) || user.getEmail().equals(userStore.get(i)) || user.getName().isEmpty() || user.getLogin().isEmpty() || user.getEmail().isEmpty()) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static synchronized MemoryStore getInstance() {
        if (instance == null) {
            instance = new MemoryStore();
        }
        return instance;
    }

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
    @Override
    public List<Role> findAllRoles() {
        return null;
    }
    @Override
    public int findByLogin(String login) {
        return 0;
    }
}
