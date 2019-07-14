package ru.job4j.menu;
import java.util.List;

public class Output<E> implements OutputMenu<E> {

    public void print(List<Node> menu) {
        String s = "";
        for (int i = 0; i < menu.size(); i++) {
            Node node = menu.get(i);
            if (node!=null) {
                s = s + node.value + "\n";
            }

            if (node.next1 != null) {
                s = s + "---- " + node.next1.value + "\n";
                if (node.next1.next1!=null) {
                    s = s + "--------- " + node.next1.next1.value + "\n";
                }
                if (node.next1.next2!=null) {
                    s = s + "--------- " + node.next1.next2.value + "\n";
                }
            }

            if (node.next2 != null) {
                s = s + "---- " + node.next2.value + "\n";
                if (node.next2.next1!=null) {
                    s = s + "--------- " + node.next2.next1.value + "\n";
                }
                if (node.next2.next2!=null) {
                    s = s + "--------- " + node.next2.next2.value + "\n";
                }
            }

        }
        System.out.println(s);
    }

}
