package ru.job4j.listNode;

public class Node<E>{
    public E value;
    public Node<E> next;

    public Node (E value) {
        this.value = value;
    }
}
