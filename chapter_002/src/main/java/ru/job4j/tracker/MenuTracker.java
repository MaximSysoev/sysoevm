package ru.job4j.tracker;

/**
 * Класс UpdateItem - обновление позиции.
 */
class UpdateItem implements UserAction {
    /**
     * Метод key - выбор пользовательского меню.
     * @return 2
     */
    public int key() {
        return 2;
    }

    /**
     * Метод execute. Иниициализация параметров для метода update.
     * @param input параметр.
     * @param tracker параметр.
     */
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите id: ");
        String name = input.ask("Введите новое имя: ");
        String desc = input.ask("Введите новое описание: ");
        Task task = new Task(name, desc);
        task.setId(id);
        tracker.update(task);
    }

    /**
     * Выполянет меню для пользователя.
     * @return String.format.
     */
    public String info() {
        return String.format("%s %s", this.key(), "Update item");
    }
}

/**
 * Класс MenuTracker.
 */
public class MenuTracker {
    /**
     * Объект input.
     */
    private Input input;
    /**
     * Объект tracker для вызовов методов.
     */
    private Tracker tracker;
    /**
     * Массив действий для пользователей actions.
     */
    private UserAction[] actions = new UserAction[10];

    /**
     * Констурктор класса.
     * @param input параметр.
     * @param tracker параметр.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод fillActions. Хранит методы в массиве actions.
     */
    public void fillActions() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new UpdateItem();
        this.actions[3] = this.new DeleteItem();
        this.actions[4] = this.new FindItemById();
        this.actions[5] = this.new FindItemByName();
    }

    /**
     * При выборе действия и выполение.
     * @param key параметр.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Вывод интерфейса для пользователя.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Внутренний класс addItem - добавляет позицию.
     */
    private class AddItem implements UserAction {
        /**
         * Метод key - выбор пользовательского меню.
         * @return 0.
         */
        public int key() {
            return 0;
        }

        /**
         * Метод execute. Иниициализация параметров для метода Add.
         * @param input параметр.
         * @param tracker параметр.
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter your name: ");
            String desc = input.ask("Please enter desc: ");
            tracker.add(new Task(name, desc));
        }

        /**
         * Возвращает строку для интерфейса.
         * @return String.format.
         */
        public String info() {
            return String.format("%s %s", this.key(), "Add the new item.");
        }
    }

    /**
     * Внутренний класс DeleteItem - удаляет позицию.
     */
    private class DeleteItem implements UserAction {
        /**
         * Метод key - выбор пользовательского меню.
         * @return 3.
         */
        public int key() {
            return 3;
        }

        /**
         * Метод execute – иниициализация параметров для метода DeleteItem.
         * @param input параметр.
         * @param tracker параметр.
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id удаляемого элемента: ");
            Item item = tracker.findById(id);
            tracker.delete(item);
        }

        /**
         * Возвращает строку для интерфейса.
         * @return String.format.
         */
        public String info() {
            return String.format("%s  %s", this.key(), "Delete item");
        }
    }

    /**
     * Внутренний класс FindItembyId - поиск элемента по id.
     */
    private class FindItemById implements UserAction {

        /**
         * Метод key - выбор пользовательского меню.
         * @return 4.
         */
        public int key() {
            return 4;
        }

        /**
         * Метод execute. Иниициализация параметров для метода FindItemById.
         * @param input параметр.
         * @param tracker параметр.
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id искомого элемента: ");
            Item item = tracker.findById(id);
            System.out.println(String.format("%s %s", item.getId(), item.getName()));
        }

        /**
         * Возвращает строку для интерфейса.
         * @return String.format.
         */
        public String info() {
            return String.format("%s  %s", this.key(), "Find item by id");
        }
    }

    /**
     * Внутренний класс FindItemByName - поиск элемента по name.
     */
    private class FindItemByName implements UserAction {

        /**
         * Метод key - выбор пользовательского меню.
         * @return 5.
         */
        public int key() {
            return 5;
        }

        /**
         * Метод execute. Иниициализация параметров для метода FindItemByName.
         * @param input параметр.
         * @param tracker параметр.
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите name искомого элемента: ");
            Item[] item = tracker.findByName(name);
            for (Item element : item) {
                if (item != null) {
                    System.out.println(String.format("%s %s", element.getId(), element.getName()));
                }
            }
        }

        /**
         * Возвращает строку для интерфейса.
         * @return String.format.
         */
        public String info() {
            return String.format("%s  %s", this.key(), "Find item by name");
        }
    }

    /**
     * Внутренний статический класс ShowItems - вывод всех элементов.
     */
    public static class ShowItems implements UserAction {
        /**
         * Метод key - выбор пользовательского меню.
         * @return 1.
         */
        public int key() {
            return 1;
        }

        /**
         * Метод execute. Иниициализация параметров для метода ShowItems.
         * @param input параметр.
         * @param tracker параметр.
         */
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                if (item != null) {
                    System.out.println(String.format("%s %s", item.getId(), item.getName()));
                }
            }
        }

        /**
         * Возвращает строку для интерфейса.
         * @return String.format.
         */
        public  String info() {
            return String.format("%s %s", this.key(), "Show all items. ");
        }
    }
}
