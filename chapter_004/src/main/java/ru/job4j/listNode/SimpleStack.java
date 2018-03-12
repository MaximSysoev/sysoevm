package ru.job4j.listNode;

import java.util.Iterator;

public class SimpleStack<E> {

    private Container<E> container = new Container<>();

    /**
     * Возвращает значение и удаляет его из позиции.
     * @return null.
     */
    public E poll() {
        E value = null;
        if (container.iterator().hasNext()) {
            value = container.head.value;
            container.head = container.head.next;
        }
        return value;
    }

    public void push(E value) {
        container.add(value);
    }
}
