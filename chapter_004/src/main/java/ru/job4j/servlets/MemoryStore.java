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
        userStore.set(id, user);
    }

    @Override
    public void delete(int key) {
        userStore.remove(key);
    }

    @Override
    public List<User> findAll() {
        return userStore;
    }

    @Override
    public User findById(int key) {
        int index = 0;
        User user = new User();
        for (User u : this.userStore) {
            if (this.userStore.get(index).id == key) {
                user = this.userStore.get(index);
                break;
            }
        }
        return user;
    }


}
