package ru.job4j.tracker;

/**
 * Класс StartUI.
 */
public class StartUI {

    private Input input;

    public StartUI(Input input) {
        this.input = input;
    }

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

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(input).init();
    }

    /**
     * Свойство input.
     */
   // private Input input;
    /**
     * Свойство tracker.
     */
   // private Tracker tracker;

    /**
     * Конструктор класса.
     * @param input параметр.
     * @param tracker параметр.
     */
  /*  public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }*/

    /**
     * Обновление позиции.
     */
   /* public void updateInit() {
        String id = input.ask("1");
        Item item = new Task(input.ask("2"), input.ask("3"));
        tracker.add(item);
        item.setId(id);
        tracker.update(item);
    }*/


    /**
     * Удаление позиции.
     */
   /* public void delInit() {
        Item one = new Task(input.ask("1"), input.ask("2"));
        tracker.add(one);
        tracker.delete(one);
        for (Item element : tracker.findAll()) {
         if (element != null) {
            System.out.println(element.getName() + " " + element.getDesc());
         }
        }
    }*/

    /**
     * Метод init.
     */
   /* public void init() {
        tracker.add(new Task(input.ask("1"), input.ask("2")));
    }*/

}