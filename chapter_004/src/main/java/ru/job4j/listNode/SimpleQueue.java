package ru.job4j.listNode;
import ru.job4j.simpleContainer.*;

public class SimpleQueue<E> {

    private Container<E> container = new Container<>();
    private ru.job4j.simpleContainer.Container<E> simpleContainer = new ru.job4j.simpleContainer.Container<>();
    private int index = 0;

    public E poll() {
        index--;
        E value = (E) simpleContainer.get(index);
        simpleContainer.remove(index);
        return value;
    }

    public void push(E value) {
        container.add(value);
        simpleContainer.add(container.head.value);
        container.head = container.head.next;
        index++;
    }
}
