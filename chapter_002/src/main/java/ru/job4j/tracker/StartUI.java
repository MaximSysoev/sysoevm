package ru.job4j.tracker;
import java.util.Scanner;

public class StartUI {
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        input.menu();
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        input.selectMenu(number);
    }

}
