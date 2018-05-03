package ru.job4j.simpleTree;
import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    Node<E> root;
    Queue<Node> queue = new LinkedList<>();

    public Tree(E value) {
        this.root = new Node<>(value);
    }

    @Override
    public boolean add(E parent, E child) {
        if (findBy(parent).isPresent() && !findBy(child).isPresent()) {
            Node<E> element = findBy(parent).get();
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

    @Override
    public Iterator<E> iterator() {
        queue.offer(root);
        return new treeIterator();
    }

    public class treeIterator<E> implements Iterator {

        @Override
        public boolean hasNext() {
            return queue.isEmpty();
        }

        @Override
        public Object next() {
            Node child = queue.poll();
            queue.offer(child);
            return child.value;
        }

    }


}