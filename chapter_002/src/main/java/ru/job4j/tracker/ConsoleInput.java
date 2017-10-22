package ru.job4j.tracker;
import java.util.Scanner;

/**
 * Работа с пользователем.
 */
public class ConsoleInput implements Input {
    /**
     * Объект Scanner.
     */
    private Scanner scanner = new Scanner(System.in);
    /**
     * Переменная ADD.
     */
    private static final String ADD = "0";
    /**
     * Переменная SHOW.
     */
    private static final String SHOW = "1";
    /**
     * Переменная EDIT.
     */
    private static final String EDIT = "2";
    /**
     * Переменная DELETE.
     */
    private static final String DELETE = "3";
    /**
     * Переменная FINDBYID.
     */
    private static final String FINDBYID = "4";
    /**
     * Переменная FINDBYNAME.
     */
    private static final String FINDBYNAME = "5";
    /**
     * Переменная EXIT.
     */
    private static final String EXIT = "6";


    /**
     * Создает вопрос.
     * @param question Параметр.
     * @return Вывод на печать и переход на новую строку.
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * Обработка ошибок.
     * @param question параметр.
     * @param range параметр.
     * @return Сообщение об ошибке.
     */
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }

        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }

    /**
     * Вывод меню для пользователя.
     */
    public void menu() {
        System.out.println("0 Add new Item");
        System.out.println("1 Show all items");
        System.out.println("2 Edit item");
        System.out.println("3 Delete item");
        System.out.println("4 Find Item by id");
        System.out.println("5 Find Items by name");
        System.out.println("6 Exit programm");
        System.out.print("Select: ");
    }

    /**
     * Выбор меню пользователем.
     * @param number передаётся в качестве параметра.
     */
    public void selectMenu(String number) {
        Tracker tracker = new Tracker();
        int ch = 0;
        while (true) {
            if (ADD.equals(number)) { // 0 Add new Item
                System.out.print("Введите имя: ");
                String name = scanner.nextLine();
                System.out.print("Введите описание: ");
                String desc = scanner.nextLine();
                tracker.add(new Task(name, desc));
                System.out.println("Успешно добавлено");
                System.out.print("Select: ");
                number = scanner.nextLine();

            } else if (SHOW.equals(number)) {  // 1 Show all items
                System.out.println("Вывод всех значений");
                for (Item item : tracker.findAll()) {
                    if (!item.equals(null)) {
                        System.out.println(item.getName() + " " + item.getId());
                    }
                }
                System.out.print("Select: ");
                number = scanner.nextLine();
            } else if (EDIT.equals(number)) {  // 2 Edit item
                System.out.println("Вывод значений");
                for (Item item : tracker.findAll()) {
                    System.out.println(item.getName() + " " + item.getId());
                }

                System.out.println("Введите id элемента, который необходимо обновить: ");
                String id = scanner.nextLine();
                Item search = tracker.findById(id);

                System.out.println("Введите имя: ");
                String name = scanner.nextLine();
                System.out.print("Введите описание: ");
                String desc = scanner.nextLine();

                Item task = new Task(name, desc);
                task.setId(search.getId());
                tracker.update(task);
                System.out.println("Select: ");
                number = scanner.nextLine();

            } else if (DELETE.equals(number)) { // 3 Delete item
                System.out.println("Вывод значений");
                for (Item item : tracker.findAll()) {
                    System.out.println(item.getName() + " " + item.getId());
                }

                System.out.println("Введите id элемента, которое необходимо удалить: ");
                String id = scanner.nextLine();
                Item itemDelete = tracker.findById(id);
                tracker.delete(itemDelete);
                System.out.println("Select: ");
                number = scanner.nextLine();

            } else if (FINDBYID.equals(number)) { // 4 Find Item by id
                System.out.println("Вывод значений");
                for (Item item : tracker.findAll()) {
                    System.out.println(item.getName() + " " + item.getId());
                }
                System.out.println("Введите id элемента: ");
                String id = scanner.nextLine();
                Item search = tracker.findById(id);
                System.out.print(search.getName());
                System.out.println("Select: ");
                number = scanner.nextLine();

            } else if (FINDBYNAME.equals(number)) { // 5 Find Items by name
                System.out.println("Введите имя элемента: ");
                String name = scanner.nextLine();
                for (Item item:tracker.findByName(name)) {
                    System.out.print(item.getName());
                }
                System.out.println("Select: ");
                number = scanner.nextLine();
            } else if (EXIT.equals(number)) { // 6 EXIT
                break;
            }
        }

    }

}