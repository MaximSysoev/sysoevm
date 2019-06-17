package ru.job4j.productStorage;
import java.util.ArrayList;
import java.util.Date;

public class Shop implements Actions {

    private ArrayList<Food> store = new ArrayList<>();

    @Override
    public void add(Food food) {
        store.add(food);
    }

    @Override
    public boolean accept(Food food) {
        Date expaireDate = food.getExpaireDate();
        Date createDate = food.getCreateDate();
        long wholeTerm = expaireDate.getTime() - createDate.getTime(); // Срок годности
        long storageTime = new Date().getTime() - createDate.getTime(); // Время хранения
        long percent = wholeTerm / 100; // Сколько составляет в мс 1 процент

        if (storageTime >= percent * 25 && storageTime <= percent * 75) {
            return true;
        } else if (storageTime > percent * 75 && storageTime < percent * 100) {
            food.setDiscont(10);
            return true;
        }
        return false;
    }

    public ArrayList<Food> getStore() {
        return store;
    }
}
