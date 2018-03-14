package ru.job4j.listNode;
import ru.job4j.simpleContainer.*;
import java.util.Iterator;

public class SimpleStack<E> {

    private Container<E> container = new Container<>();
    private ru.job4j.simpleContainer.Container<E> simpleContainer = new ru.job4j.simpleContainer.Container<>();
    private int index = 0;

    /**
     * Возвращает значение и удаляет его из позиции.
     * @return null.
     */

    public E poll() {
        E value = (E) simpleContainer.get(index);
        simpleContainer.remove(index);
        index++;
        return value;
    }

    public void push(E value) {
        container.add(value);
        simpleContainer.add(container.head.value);
        container.head = container.head.next;
    }
}
