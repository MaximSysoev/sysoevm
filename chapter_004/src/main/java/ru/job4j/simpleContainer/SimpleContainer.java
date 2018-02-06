package ru.job4j.simpleContainer;

import java.util.ArrayList;

public interface SimpleContainer<E> {
    void add(E value);
    E get(int index);

}
