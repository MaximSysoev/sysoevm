package ru.job4j.store;

public abstract class Base {
    final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
