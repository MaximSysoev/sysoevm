package ru.job4j.simpleTree;
import java.util.*;

public abstract class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    Node<E> root;

    @Override
    public boolean add(E parent, E child) {
        if (findBy(parent).isPresent()) { // Если есть родительский элемент.
            if (!findBy(child).isPresent()) { // и при этом нет дочернего элемента.
                root.add(new Node<>(child)); // в корневой узел добавляю новый дочерний.
                return true;
            } else {
                return false;
            }
        } else {
            Node<E> node = new Node<>(parent); // Иначе если нет родительского элемента – создаётся новый узел.
            node.add(new Node<>(child)); // К новому узлу добавляется новый дочерний узел.
            root.add(node); // и всё это добавляется в корневой главный узел.
            return true;
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
}