package ru.job4j.tracker;
import java.util.*;
import java.util.Arrays;

public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    public void assingValue(Item value) {
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(value.getId())) {
                this.items[index] = value;
                break;
            }
        }
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        if (this.position<this.items.length) {
            this.items[position++] = item;
        }
        return item;
    }

    public void update(Item item) {
        this.assingValue(item);
    }

    public void delete(Item item) {
       this.assingValue(null);
    }

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

    private String generateId() {
         return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }
}
