package ru.job4j.productStorage;

import java.util.ArrayList;

public class AdditionalWarehouse extends Warehouse {

    private ArrayList<Food> store = new ArrayList<>();

    @Override
    public void add(Food food) {
        this.store.add(food);
        System.out.println("Отправлено на дополнительный склад");
    }

    public ArrayList<Food> getStore() {
        return store;
    }
}
