package ru.job4j.menu;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SelectMenu implements Input {
    @Override
    public void print(Node head) {}

    @Override
    public Node getNode(String id, String value, List list) {
        return null;
    }

    @Override
    public void add(String id, String value) {}

    @Override
    public void load() {}

    public void select() throws Exception {
        CreateMenu createMenu = new CreateMenu();
        Output out = new Output();
        createMenu.load();
        out.print(createMenu.head);
        System.out.println(out.outputData);

        System.out.print("Ввод чисел от 1 до 16: ");

        try (BufferedInputStream bis = new BufferedInputStream(System.in)) {
            Scanner scanner = new Scanner(bis);
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    System.out.println("Задача 1");
                    break;
                case 2:
                    System.out.println("Задача 1.1");
                    break;
                case 3:
                    System.out.println("Задача 1.1.1");
                    break;
                case 4:
                    System.out.println("Задача 1.1.2");
                    break;
                case 5:
                    System.out.println("Задача 1.2");
                    break;
                case 6:
                    System.out.println("Задача 1.2.1");
                    break;
                case 7:
                    System.out.println("Задача 1.2.2");
                    break;
                case 8:
                    System.out.println("Задача 1.2.3");
                    break;
                case 9:
                    System.out.println("Задача 2");
                    break;
                case 10:
                    System.out.println("Задача 2.1");
                    break;
                case 11:
                    System.out.println("Задача 2.2");
                    break;
                case 12:
                    System.out.println("Задача 3");
                    break;
                case 13:
                    System.out.println("Задача 3.1");
                    break;
                case 14:
                    System.out.println("Задача 3.1.1");
                    break;
                case 15:
                    System.out.println("Задача 3.2");
                    break;
                case 16:
                    System.out.println("Задача 4");
                    break;
                case 17:
                    System.out.println("exit");
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new SelectMenu().select();
    }

}
