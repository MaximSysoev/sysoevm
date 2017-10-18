package ru.job4j.tracker;

/**
 * Класс StubInput.
 */
public class StubInput implements Input {
    /**
     * Переменные answers.
     */
    private String[] answers;
    /**
     * Переменная position.
     */
   // private int position = 0;
    /**
     * Метод StubInput.
     * @param answers параметр.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }
    /**
     * Метод ask.
     * @param position параметр.
     * @return answers.
     */
    public String ask(String position) {
        int index = Integer.parseInt(position);
        return answers[index];
    }
}