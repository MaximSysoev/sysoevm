package ru.job4j.servlets.userstore;
import java.util.List;

public interface Store {
    void add(User user);
    void update(int id, User user);
    void delete(int key);
    List<User> findAll();
    List<Role> findAllRoles();
    User findById(int key);
    int findByLogin(String login);
    boolean contain(User user);
}
