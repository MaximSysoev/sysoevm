package ru.job4j.tracker;
import java.util.Scanner;

public class StartUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleInput input = new ConsoleInput();
        input.menu();
        String number = scanner.nextLine();
        input.selectMenu(number);
    }

}
