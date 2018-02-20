package ru.job4j.listNode;

public class Container<E> {

    private Node<E> head;
    private Node<E> tail;

    public void add(E value) {
        if (head == null) {
            head = new Node<>();
        } else {
            if (head.next!=null) {
                tail = head.next;
                if (tail.next == null) {
                    tail.next = new Node<>();
                }
            }
        }
        head.value = value;
    }
}
