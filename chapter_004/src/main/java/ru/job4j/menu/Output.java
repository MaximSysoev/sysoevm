package ru.job4j.menu;
import java.util.ArrayList;
import java.util.List;

public class Output<E> implements OutputMenu<E> {

    public String outputData = "";

    public String item(String value) {
        String item = "";
        String[] arr = value.split("\\.");
        for (int i = 0; i < arr.length; i++) {
            item = item + "----";
        }
        return item;
    }

    @Override
    public void print(Node<E> head) {
        List<Node<E>> list = head.list;
        for (int i = 0; i < list.size(); i++) {
            Node<E> newNode = list.get(i);
            outputData = outputData + this.item(newNode.value) + " " + newNode.value + "\n";
            if (newNode.list.size() != 0) {
                print(newNode);
            }
        }
    }
}
