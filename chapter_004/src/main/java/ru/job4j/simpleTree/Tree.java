package ru.job4j.simpleTree;

import java.util.*;

public abstract class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    Node<E> root;

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
      if (findBy(parent).equals(parent)) {
          if (findBy(child).equals(Optional.empty())) {
              root.add(new Node<>(child));
              result = true;
          }
      } else {
          root.add(new Node<>(parent));
          result = true;
      }
        return result;
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