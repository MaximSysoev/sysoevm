package ru.job4j.tracker;

/**
 * Класс StartUI.
 */
public class StartUI {

    /**
     * параметр input.
     */
    private int[] range = new int[6];

    /**
     * Объект trk.
     */
    private MenuTracker trk = new MenuTracker();

    /**
     * Объект input.
     */
    private Input input;

    /**
     * Получение диапазона значений.
     * @return range параметр.
     */
    private int[] getRange() {
        MenuTracker trk = new MenuTracker();
        for (int index = 0; index < trk.getActions().length; index++) {
            range[index] = index;
        }
        return range;
    }

    /**
     * Конструктор класса.
     */
    public StartUI() {

    }

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
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        this.getRange();
        do {
            menu.show();
            menu.select(input.ask("select: ", range));
        } while (!"y".equals(this.input.ask("Exit?(y):")));
    }

    /**
     * Главый метод main.
     * @param args параметр.
     */
    public static void main(String[] args) {
        StartUI start = new StartUI();
        Input input = new ValidateInput();
        new StartUI(input).init();

    }
}