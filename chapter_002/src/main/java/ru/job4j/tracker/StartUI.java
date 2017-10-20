package ru.job4j.tracker;

/**
 * Класс StartUI.
 */
public class StartUI {

    /**
     * параметр input.
     */
    private Input input;

    /**
     * Конструктор класса.
     * @param input параметр.
     */
    public StartUI(Input input) {
        this.input = input;
    }

    /**
     * Интрефейс работы с пользователем.
     */
    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(input, tracker);
        menu.fillActions();

        do {
            menu.show();
            int key = Integer.valueOf(input.ask("select: "));
            menu.select(key);
        } while (!"y".equals(this.input.ask("Exit?(y):")));
    }

    /**
     * Главый метод main.
     * @param args параметр.
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(input).init();
    }
}