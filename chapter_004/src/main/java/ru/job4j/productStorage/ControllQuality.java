package ru.job4j.productStorage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ControllQuality {

    private Actions actions;

    public void execute(Food food) {
        actions.add(food);
    }

    public void directionProduct(Food food) {
        if (new Warehouse().accept(food)) {
            this.actions = new Warehouse();
            this.execute(food);
        } else if (new Shop().accept(food)) {
            this.actions = new Shop();
            this.execute(food);
        } else if (new Trash().accept(food)) {
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
