package ru.job4j.store;
import ru.job4j.simpeArray.*;

public class User extends Base {

    public User(String id) {
        super(id);
    }

    public static void main(String[] args) {
        UserStore userStore = new UserStore(new SimpleArray<Base>());
        Base base1 = new User("0");
        Base base2 = new User("1");
        userStore.add(base1);
        userStore.add(base2);
        userStore.delete(base2.getId());
        System.out.println(userStore.simpleArray.arrayList.get(0).getId());

    }
}
