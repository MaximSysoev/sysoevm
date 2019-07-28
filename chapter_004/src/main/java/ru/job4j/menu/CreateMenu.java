package ru.job4j.menu;
import java.util.ArrayList;
import java.util.List;

public class CreateMenu<E> implements Menu {

    public List<Node> menu = new ArrayList<>();
    public Node head;
    Node<E> node = null;

    @Override
    public Node getNode(String id, String value, List list) {
        List<Node<E>> lst = list;
        String[] arr = id.split("-");
        int level = arr.length;
        int count = 1;
        for (int i=0; i<arr.length; i++) {
            node = lst.get(Integer.parseInt(arr[i]));
            if (node.list.size() != 0) {
                lst = node.list;
                count++;
                if (level==count) {
                    lst.add(new Node<>(id, value));
                    break;
                }
            } else {
                lst = node.list;
                lst.add(new Node<>(id, value));
                break;
            }
        }
        return node;
    }

    @Override
    public void add(String id, String value) {
        int level = id.length() - 1;
        if (level == 0) {
            if (head == null) {
                head = new Node(id, value);
            }
            head.list.add(new Node(id, value));
        } else {
            getNode(id, value, head.list);
        }
    }

    public void load() {
        this.add("0", "Задача 1.");
        this.add("1", "Задача 2.");
        this.add("2", "Задача 3.");

        this.add("0-0", "Задача 1.1");
        this.add("0-1", "Задача 1.2");

        this.add("1-0", "Задача 2.1");
        this.add("1-1", "Задача 2.2");

        this.add("0-1-1", "Задача 1.2.1");
        this.add("0-1-2", "Задача 1.2.2");
        this.add("0-1-3", "Задача 1.2.3");

        this.add("0-0-1", "Задача 1.1.1");
        this.add("0-0-2", "Задача 1.1.2");

        this.add("2-0", "Задача 3.1");
        this.add("2-0-0", "Задача 3.1.1");
        this.add("2-1", "Задача 3.2");

        this.add("3", "Задача 4");
    }

}
