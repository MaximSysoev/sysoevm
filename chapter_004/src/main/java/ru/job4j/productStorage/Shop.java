package ru.job4j.productStorage;

import java.util.ArrayList;

public class Shop implements Actions {
    private ArrayList<Food> store = new ArrayList<>();
    @Override
    public void add(Food food) {
        store.add(food);
    }
    public ArrayList<Food> getStore() {
        return store;
    }
}
