package ru.job4j.store;
import ru.job4j.simpeArray.*;

public class User extends Base {

    public User(String id) {
        super(id);
    }

    public static void main(String[] args) {
        UserStore userStore = new UserStore(new SimpleArray<User>());
        User user1 = new User("001");
        User user2 = new User("111");
        userStore.add(user1);
        userStore.add(user2);
       // userStore.delete(base2.getId());
        System.out.println(userStore.simpleArray.arrayList.get(0).getId());
    }
}
