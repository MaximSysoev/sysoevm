package ru.job4j.store;
import ru.job4j.simpeArray.*;

public class UserStore extends AbstractStore<User> {
    public UserStore() {
        super(new SimpleArray<>());
    }
}
