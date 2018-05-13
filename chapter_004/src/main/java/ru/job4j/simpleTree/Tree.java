package ru.job4j.simpleTree;
import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    Node<E> root;
    Queue<Node> queue = new LinkedList<>();

    public Tree(E value) {
        this.root = new Node<>(value);
    }

    public boolean add(E value) {
        if (!findBy(value).isPresent()) {
            List<Node<E>> list = root.leaves();
        } else {
            return false;
        }
        return true;
    }

    public boolean bin(List<Node<E>> list) {
        boolean result;
        if (list.size() <= 2 ) {
            result = true;
            for (int i = 0; i < list.size(); i++) {
                result = bin(list.get(i).leaves());
            }
        } else {
            result = false;
        }
        return result;
    }

    public boolean isBinary() {
        boolean result = true;
        if (this.root.leaves().size() <= 2) {
            List<Node<E>> list = root.leaves();
            result = bin(list);
        } else {
            result = false;
        }
        return result;
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
            return !queue.isEmpty();
        }

        @Override
        public Object next() {
            if (hasNext()) {
                Node node = queue.poll();
                queue.addAll(node.leaves());
                return node.value;
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}