package ru.job4j.tracker;

/**
 * Абстрактный класс baseAction.
 */
abstract class BaseAction implements UserAction {
    /**
     * Переменная name.
     */
    private String name;

    /**
     * Переменная key.
     */
    private int key;

    /**
     * Конструктор класса BaseAction.
     * @param key параметр.
     * @param name параметр.
     */
    BaseAction(int key, String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * Установка цифры для интерфейса.
     * @return цифру(ключ).
     */
    public int key() {
        return this.key;
    }

    /**
     * Метод execute – иниициализация параметров для методов.
     * @param input параметр.
     * @param tracker параметр.
     */
    public abstract void execute(Input input, Tracker tracker);

    /**
     * Вывод строчки информации.
     * @return String.format.
     */
    public String info() {
        return String.format("%s %s", this.key(), this.name);
    }

}
