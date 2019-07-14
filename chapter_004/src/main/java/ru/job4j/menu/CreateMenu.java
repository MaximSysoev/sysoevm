package ru.job4j.menu;
import java.util.ArrayList;
import java.util.List;

public class CreateMenu<E> implements Menu {

    public List<Node> menu = new ArrayList<>();

    public Node<E> getNode(String id, int level) {
        Node<E> newNode = null;
            for (Node<E> node : menu) {
                if (node.id.equals(id.substring(0, 1))) {
                    if (level == 1) {
                        newNode = node;
                        break;
                    } else if (level == 2) {
                        Node<E> next1 = node.next1;
                        Node<E> next2 = node.next2;
                        if (next1.id.equals(id.substring(0,3))) {
                            newNode = next1;
                            break;
                        } else if (next2.id.equals(id.substring(0,3))) {
                            newNode = next2;
                            break;
                        }
                    }
                }
            }
        return newNode;
    }


    public void add(String id, String value, int level) {
        if (level == 0) {
            this.menu.add(new Node(id, value));
        } else if (level == 1) {
            Node<E> node = this.getNode(id, level);
            if (node.next1 == null) {
                node.next1 = new Node<>(id, value);
            } else if (node.next2 == null) {
                node.next2 = new Node<>(id, value);
            }
        } else if (level == 2) {
            Node<E> node = this.getNode(id, level);
            if (node.next1 == null) {
                node.next1 = new Node<>(id, value);
            } else if (node.next2 == null) {
                node.next2 = new Node<>(id, value);
            }
        }
    }

    public void load() {
        this.add("0", "Задача 1.", 0);
        this.add("1", "Задача 2.", 0);
        this.add("0.1", "Задача 1.1", 1);
        this.add("0.2", "Задача 1.2", 1);
        this.add("0.1.1", "Задача 1.1.1", 2);
        this.add("0.1.1", "Задача 1.1.2", 2);
        this.add("0.2.1", "Задача 1.2.1", 2);
    }


}
