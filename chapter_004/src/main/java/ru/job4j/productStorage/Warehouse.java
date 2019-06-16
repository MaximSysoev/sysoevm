package ru.job4j.productStorage;

import java.util.ArrayList;

public class Warehouse implements Actions {

    private ArrayList<Food> store = new ArrayList<>();

    @Override
    public void add(Food food) {
        this.store.add(food);
    }

    public ArrayList<Food> getStore() {
        return store;
    }
}
