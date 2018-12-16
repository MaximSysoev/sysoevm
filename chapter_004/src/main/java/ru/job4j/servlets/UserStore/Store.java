package ru.job4j.servlets.UserStore;

import java.util.List;

public interface Store {
    void add(User user);
    void update (int id, User user);
    void delete (int key);
    List<User> findAll();
    User findById(int key);

}
