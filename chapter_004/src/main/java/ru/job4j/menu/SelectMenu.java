package ru.job4j.menu;

import java.io.BufferedInputStream;
import java.util.List;
import java.util.Scanner;

public class SelectMenu implements Input {
    @Override
    public void print(List menu) {}

    @Override
    public Node getNode(String id, int level) {
        return null;
    }

    @Override
    public void add(String id, String value, int level) {}

    @Override
    public void load() {}

    public void select() throws Exception {
        Output output = new Output();
        CreateMenu createMenu = new CreateMenu();
        createMenu.load();
        output.print(createMenu.menu);
        System.out.print("Ввод чисел от 1 до 8: ");

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
                    System.out.println("Задача 2.");
                    break;
                case 8:
                    System.out.println("exit");
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SelectMenu selectMenu = new SelectMenu();
        selectMenu.select();
    }

}
