package ru.job4j.simpleTree;
import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    Node<E> root;

    public Tree(E value) {
        this.root = new Node<>(value);
    }

    public boolean contains(List<Node<E>> list, Node<E> children) {
        for (int i = 0; i < list.size(); i++) {
            Node<E> node = list.get(i);
            if (node.value == children.value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(E parent, E child) {
        if (findBy(parent).isPresent()) {

            Node<E> element = findBy(parent).get();
            List<Node<E>> list = element.leaves();
            Node<E> children = new Node<>(child);

            if (contains(list, children)) {
                return false;
            }

            element.add(new Node<>(child));
            return true;

        } else {
           return false;
        }
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    public class treeIterator<E> implements Iterator {

        Queue<Node> data = new LinkedList<>();
        Node next = new Node(null);

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Object next() {
            data.offer(root);
            while (!data.isEmpty()) {
                next = data.poll();
                break;
            }
            return next;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new treeIterator();
    }
}