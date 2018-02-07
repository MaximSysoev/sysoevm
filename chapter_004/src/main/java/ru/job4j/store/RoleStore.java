package ru.job4j.store;
import ru.job4j.simpeArray.*;

public class RoleStore extends AbstractStore<Role> {
    public RoleStore() {
        super(new SimpleArray<>());
    }
}
