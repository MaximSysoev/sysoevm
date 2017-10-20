package ru.job4j.tracker;

/**
 * Интерфейс UserAction.
 */
public interface UserAction {
    /**
     * Метод key.
     * @return key.
     */
    int key();

    /**
     * Метод execute.
     * @param input параметр.
     * @param tracker параметр.
     */
    void execute(Input input, Tracker tracker);

    /**
     * Параметр Info.
     * @return String.format.
     */
    String info();
}
