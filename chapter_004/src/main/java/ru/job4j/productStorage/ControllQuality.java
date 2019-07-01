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

    public static void main(String[] args) throws Exception {
        new RFood(new AdditionalWarehouse(),"Sugar", new SimpleDateFormat("dd.MM.yyyy").parse("23.06.2020"), new SimpleDateFormat("dd.MM.yyyy").parse("14.06.2019"), 10, 0, false).add();
        new RFood(new LowTemperatureWarehouse(new Warehouse()), "Potato", new SimpleDateFormat("dd.MM.yyyy").parse("23.06.2020"), new SimpleDateFormat("dd.MM.yyyy").parse("14.06.2019"), 10, 0, true).add();
        new RFood(new TrashReproduct(new Trash()), "Apple", new SimpleDateFormat("dd.MM.yyyy").parse("20.06.2019"), new SimpleDateFormat("dd.MM.yyyy").parse("14.06.2019"), 10, 0, true).add();

     }
}
