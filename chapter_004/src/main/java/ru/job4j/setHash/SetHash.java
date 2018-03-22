package ru.job4j.setHash;

public class SetHash<E> {

    private E key;
    private String value;

    public SetHash(E key, String value) {
        this.key = key;
        this.value = value;
    }

    public E getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setKey(E key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
