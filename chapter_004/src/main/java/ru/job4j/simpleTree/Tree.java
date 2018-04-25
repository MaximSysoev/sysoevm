package ru.job4j.simpleTree;
import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    Node<E> root;

    public Tree(E value) {
        this.root = new Node<>(value);
    }

    @Override
    public boolean add(E parent, E child) {
        if (findBy(parent).isPresent()) { // Если есть родительский элемент.
            Node<E> element = (Node)findBy(parent).get();
            element.add(new Node<>(child));
            return true;
        } else {
           return false;
        }
    }

    @Override
    public Optional findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty(); // Создаётся объект типа optional.
        Queue<Node<E>> data = new LinkedList<>(); // Создаётся объект типа Queue
        data.offer(this.root); // добавляется в очередь объект root
        while (!data.isEmpty()) {
            Node<E> el = data.poll(); // Получаем объект из очереди.
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
        return null;
    }
}