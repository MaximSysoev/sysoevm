package ru.job4j.store;
import ru.job4j.simpeArray.SimpleArray;

public class UserStore extends AbstractStore<User> {
    public UserStore(SimpleArray<User> simpleArray) {
        super(simpleArray);
    }
}
