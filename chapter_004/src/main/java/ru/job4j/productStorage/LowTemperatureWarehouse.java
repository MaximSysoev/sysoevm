package ru.job4j.productStorage;

import java.util.ArrayList;

public class LowTemperatureWarehouse extends Reproduct {
    private ArrayList<Food> store = new ArrayList();

    public LowTemperatureWarehouse(Actions reproductAction) {
        super(reproductAction);
    }

    @Override
    public boolean accept(Food food) {
        if (food.canReproduct) {
            return true;
        }
        return false;
    }

    @Override
    public void add(Food food) {
        if (accept(food)) {
            this.store.add(food);
            System.out.println("Отправлено на склад с низкой температурой");
        }
    }
}
