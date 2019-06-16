package ru.job4j.productStorage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ControllQuality {
    private Actions actions;

    public void execute(Food food) {
        actions.add(food);
    }

    public void directionProduct(Food food) {
        Date expaireDate = food.getExpaireDate();
        Date createDate = food.getCreateDate();
        long wholeTerm = expaireDate.getTime() - createDate.getTime(); // Срок годности
        long storageTime = new Date().getTime() - createDate.getTime(); // Время хранения
        long percent = wholeTerm / 100; // Сколько составляет в мс 1 процент

        if (storageTime < percent * 25) {
            this.actions = new Warehouse();
            this.execute(food);
        } else if (storageTime >= percent * 25 && storageTime <= percent * 75) {
            this.actions = new Shop();
            this.execute(food);
        } else if (storageTime > percent * 75 && storageTime < percent * 100) {
            this.actions = new Shop();
            food.setDiscont(10);
            this.execute(food);
        } else if (storageTime > percent * 100) {
            this.actions = new Trash();
            this.execute(food);
        }
    }


    public static void main(String[] args) throws Exception {
        ControllQuality controllQuality = new ControllQuality();
        Food apple = new Food("Apple", new SimpleDateFormat("dd.MM.yyyy").parse("20.06.2019"), new SimpleDateFormat("dd.MM.yyyy").parse("14.06.2019"), 10, 5);
        controllQuality.directionProduct(apple);
    }
}
