package ru.job4j.tracker;
import java.util.*;
import java.util.Arrays;

public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    public void update(Item item) {
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(item.getId())) {
                this.items[index] = item;
            }
        }
    }

    public void delete(Item item) {
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(item.getId())) {
                this.items[index] = null;
            }
        }
    }


    public Item[] findAll() {
        Item[] result = new Item[this.position];
        int k = 0;
        for (int index = 0; index < this.position; index++) {
           if (this.items[index] != null) {
               result[k] = this.items[index];
               k++;
            }
        }
        return result;
    }

    public Item[] findByName(String key) {
        int k = 0;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getName().equals(key)) {
                k++;
            }
        }

        Item[] result = new Item[k];
        for (int index = 0; index < k; index++) {
            result[k] = this.items[index];
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
