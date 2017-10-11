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
        Item[] result = new Item[this.position];
        int index = 0;
        for (Item element : result) {
           if ( this.items[index].getId() == item.getId() ) {
                this.items[index] = item;
            }
            index++;
        }
    }

    public void delete(Item item) {
        Item[] result = new Item[this.position];
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId()==item.getId()) {
                this.items[index].setId("null");
                this.items[index].setName("null");
                this.items[index].setDesc("null");
            }
        }
    }


    public Item[] findAll() {
        Item[] result = new Item[this.position];
        int k = 0;
        for (int index = 0; index < this.position; index++) {
           if (this.items[index].getId() != null) {
               result[k] = this.items[index];
               k++;
            }
        }
        return result;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int k = 0;
        for (int index = 0; index < result.length; index++) {
            if (this.items[index].getName() == key) {
                result[k] = this.items[index];
                k++;
            }
        }
        return result;
    }

    public Item findById(String id) {
        Item res = new Item();
        for (int index = 0; index < this.position; index++) {
            if (items[index].getId() == id) {
                res = items[index];
            }
        }
        return res;
    }

    private String generateId() {
         return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }
}
