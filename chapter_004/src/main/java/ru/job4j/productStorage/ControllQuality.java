package ru.job4j.productStorage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ControllQuality {

    private Actions actions;

    public ControllQuality(Actions actions) {
        this.actions = actions;
    }

    public void execute(Food food) {
        actions.add(food);
    }

    public static void main(String[] args) throws Exception {
        ControllQuality controllQuality = new ControllQuality(new Shop());
        Food apple = new Food("Apple", new SimpleDateFormat("dd.MM.yyyy").parse("20.06.2019"), new SimpleDateFormat("dd.MM.yyyy").parse("14.06.2019"), 10, 5);
        controllQuality.execute(apple);
    }
}
