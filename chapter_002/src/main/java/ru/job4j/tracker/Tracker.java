package ru.job4j.tracker;
import java.util.Random;

/**
 * Класс Tracker.
 */
public class Tracker {
    /**
     * Массив Item для создания заявок.
     */
    private Item[] items = new Item[100];
    /**
     * Счётчик.
     */
    private int position = 0;
    /**
     * Переменная Random.
     */
    private static final Random RN = new Random();

    /**
     * Устанавливает значение для Item.
     * @param value параметр.
     */
    public void assingValue(Item value) {
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(value.getId())) {
                this.items[index] = value;
                break;
            }
        }
    }

    /**
     * Создание заявок.
     * @param item параметр.
     * @return item.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        if (this.position < this.items.length) {
            this.items[position++] = item;
        }
        return item;
    }

    /**
     * Обновление заявки.
     * @param item параметр.
     */
    public void update(Item item) {
        this.assingValue(item);
    }

    /**
     * Удаление заявки.
     * @param item параметр.
     */
    public void delete(Item item) {
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(item.getId())) {
                this.items[index] = null;
                break;
            }
        }
    }

    /**
     * Поиск всех заявок.
     * @return result.
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        int k = 0;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index] != null) {
                result[k++] = this.items[index];
            }
        }
        return result;
    }

    /**
     * Поиск заявки по имени.
     * @param key строковый раметр.
     * @return result.
     */
    public Item[] findByName(String key) {
        int k = 0, j = 0;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getName().equals(key)) {
                k++;
            }
        }

        Item[] result = new Item[k];
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getName().equals(key)) {
                result[j] = this.items[index];
                j++;
            }
        }
        return result;
    }

    /**
     * Поиск по id.
     * @param id параметр.
     * @return res.
     */
    public Item findById(String id) {
        Item res = new Item();
        for (int index = 0; index < this.position; index++) {
            if (items[index].getId().equals(id)) {
                res = items[index];
                break;
            }
        }
        return res;
    }

    /**
     * генерация случайного значения.
     * @return случайное значение.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }
}
