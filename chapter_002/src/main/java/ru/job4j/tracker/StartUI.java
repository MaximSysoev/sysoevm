package ru.job4j.tracker;


/**
 * Класс StartUI.
 */
public class StartUI {

    private Input input;
    private Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Обновление позиции
     */
    public void updateInit() {
        String id = input.ask("1");
        Item item = new Task(input.ask("2"), input.ask("3"));
        tracker.add(item);
        item.setId(id);
        tracker.update(item);
    }


    /**
     * Удаление позиции
     */
    public void delInit() {
        Item one = new Task(input.ask("1"), input.ask("2"));
        tracker.add(one);
        tracker.delete(one);
        for (Item element : tracker.findAll()) {
         if (element!=null) {
            System.out.println(element.getName() + " " + element.getDesc());
         }
        }
    }

    /**
     * Метод init
     */
    public void init() {
        tracker.add(new Task(input.ask("1"), input.ask("2")));
    }



}