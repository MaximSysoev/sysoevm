package ru.job4j.tracker;

import javax.jws.soap.SOAPBinding;

class UpdateItem implements UserAction {
    public int key() {
        return 2;
    }

    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите id: ");
        String name = input.ask("Введите новое имя: ");
        String desc = input.ask("Введите новое описание: ");
        Task task = new Task(name, desc);
        task.setId(id);
        tracker.update(task);
    }

    public String info() {
        return String.format("%s %s", this.key(), "Обновление позиции.");
    }
}

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[10];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new UpdateItem();
        this.actions[3] = this.new DeleteItem();
        this.actions[4] = this.new FindItemById();
        this.actions[5] = this.new FindItemByName();
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {
        public int key() {
            return 0;
        }
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter your name: ");
            String desc = input.ask("Please enter desc: ");
            tracker.add(new Task(name, desc));
        }
        public String info() {
            return String.format("%s %s", this.key(), "Add the new item.");
        }
    }

    private class DeleteItem implements UserAction {
        public int key() {
            return 3;
        }
        public void execute (Input input, Tracker tracker) {
            String id = input.ask("Введите id удаляемого элемента: ");
            Item item = tracker.findById(id);
            tracker.delete(item);
        }
        public String info() {
            return String.format("%s  %s", this.key(), "Delete item");
        }
    }

    private class FindItemById implements UserAction {
        public int key() {
            return 4;
        }
        public void execute (Input input, Tracker tracker) {
            String id = input.ask("Введите id искомого элемента: ");
            Item item = tracker.findById(id);
            System.out.println(String.format("%s %s", item.getId(), item.getName()));

        }
        public String info() {
            return String.format("%s  %s", this.key(), "Find item by id");
        }
    }

    private class FindItemByName implements UserAction {
        public int key() {
            return 5;
        }
        public void execute (Input input, Tracker tracker) {
            String name = input.ask("Введите name искомого элемента: ");
            Item[] item = tracker.findByName(name);
            for (Item element : item) {
                if (item != null ) {
                    System.out.println(String.format("%s %s", element.getId(), element.getName()));
                }
            }

        }
        public String info() {
            return String.format("%s  %s", this.key(), "Find item by name");
        }
    }


    public static class ShowItems implements UserAction {
        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                if (item != null) {
                    System.out.println(String.format("%s %s", item.getId(), item.getName()));
                }
            }
        }

        public  String info() {
            return String.format("%s %s", this.key(), "Show all items. ");
        }
    }
}
