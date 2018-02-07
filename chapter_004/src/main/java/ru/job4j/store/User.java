package ru.job4j.store;
import ru.job4j.simpeArray.*;
import java.util.*;

public class User extends Base {
    public User(String id) {
        super(id);
    }

    public static void main(String[] args) {
        UserStore userStore = new UserStore();
        User user1 = new User("1");
        User user2 = new User("2");
        User user3 = new User("3");
        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);
        userStore.delete(user1.getId());
        System.out.println(userStore.simpleArray.arrayList.get(0).getId());
        System.out.println(userStore.findById(user2.getId()));
    }
}
