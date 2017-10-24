package ru.job4j.tracker;

/**
 * Класс UpdateItem - обновление позиции.
 */
class UpdateItem extends BaseAction {

    /**
     * Передача в конструктор родительского конструктора.
     * @param key параметр.
     * @param name параметр.
     */
    UpdateItem(int key, String name) {
        super(key, name);
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
        return super.info();
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
    private UserAction[] actions = new UserAction[6];

    /**
     * Конструктор класса MenuTracker.
     */
    public MenuTracker() {

    }

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
        this.actions[0] = this.new AddItem(0, "Add the new item.");
        this.actions[1] = new MenuTracker.ShowItems(1, "Show all items.");
        this.actions[2] = new UpdateItem(2, "Update item");
        this.actions[3] = this.new DeleteItem(3, "Delete item");
        this.actions[4] = this.new FindItemById(4, "Find item by id");
        this.actions[5] = this.new FindItemByName(5, "Find item by name");
    }

    /**
     * Диапазон значений ввода пользователя.
     * @return actions.
     */
    public UserAction[] getActions() {
        return actions;
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
    private class AddItem extends BaseAction {

        /**
         * Передача в конструктор родительского конструктора.
         * @param key параметр.
         * @param name параметр.
         */
        AddItem(int key, String name) {
            super(key, name);
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
            return super.info();
        }
    }

    /**
     * Внутренний класс DeleteItem - удаляет позицию.
     */

    private class DeleteItem extends BaseAction {
        /**
         * Передача в конструктор родительского конструктора.
         * @param key параметр.
         * @param name параметр.
         */
        DeleteItem(int key, String name) {
            super(key, name);
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
            return super.info();
        }
    }

    /**
     * Внутренний класс FindItembyId - поиск элемента по id.
     */
    private class FindItemById extends BaseAction {

        /**
         * Передача в конструктор родительского конструктора.
         * @param key параметр.
         * @param name параметр.
         */
        FindItemById(int key, String name) {
            super(key, name);
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
            return super.info();
        }
    }

    /**
     * Внутренний класс FindItemByName - поиск элемента по name.
     */
    private class FindItemByName extends BaseAction {

        /**
         * Передача в конструктор родительского конструктора.
         * @param key параметр.
         * @param name параметр.
         */
        FindItemByName(int key, String name) {
            super(key, name);
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
            return super.info();
        }
    }

    /**
     * Внутренний статический класс ShowItems - вывод всех элементов.
     */
    public static class ShowItems extends BaseAction {

        /**
         * Передача в конструктор родительского конструктора.
         * @param key параметр.
         * @param name параметр.
         */
        ShowItems(int key, String name) {
            super(key, name);
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
            return super.info();
        }
    }
}
