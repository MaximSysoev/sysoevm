package ru.job4j.productStorage;

import java.text.SimpleDateFormat;

public class ControllQuality {

    private Actions actions;

    public ControllQuality(Actions actions) {
        this.actions = actions;
    }

    public void execute(Food food) {
        actions.add(food);
    }

}
