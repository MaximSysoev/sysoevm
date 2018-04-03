package ru.job4j.simpleTree;

import java.util.*;

public abstract class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    Node<E> root;

    public Tree(E value) {
        this.root = new Node<>(value);
    }

    @Override
    public boolean add(E parent, E child) {
        if (root.equals(parent)) {
            root.add(new Node<>(child));
        } else {
            root = new Node<>(parent);
            root.add(new Node<>(child));
         }
        return true;
    }

    @Override
    public Optional findBy(E value) {
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
}