package ru.job4j.listNode;

public class Node<E>{
    public E value;
    public Node<E> next;

    public Node (E value) {
        this.value = value;
    }

    public boolean hasCycle(Node<E> node) {
        boolean result = false;
        Node<E> temp = node;

        while (temp.next != null) {
            Node<E> one = temp;
            Node<E> two = temp.next;
            if (two.next == one || two.next == node) {
                result = true;
                break;
            }
            temp = temp.next;
        }
        return result;
    }
}
