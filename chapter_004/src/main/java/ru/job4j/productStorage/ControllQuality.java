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

        ControllQuality additionalWarehouse = new ControllQuality(new AdditionalWarehouse());
        additionalWarehouse.execute(new Food("Sugar", new SimpleDateFormat("dd.MM.yyyy").parse("23.06.2020"), new SimpleDateFormat("dd.MM.yyyy").parse("14.06.2019"), 10, 0, false));

        Actions onReproductVagetable= new LowTemperatureWarehouse(new Warehouse());
        onReproductVagetable.add(new Food("Potato", new SimpleDateFormat("dd.MM.yyyy").parse("23.06.2020"), new SimpleDateFormat("dd.MM.yyyy").parse("14.06.2019"), 10, 0, true));

        Actions onReproductFruits = new TrashReproduct(new Trash());
        onReproductFruits.add(new Food("Apple", new SimpleDateFormat("dd.MM.yyyy").parse("20.06.2019"), new SimpleDateFormat("dd.MM.yyyy").parse("14.06.2019"), 10, 0, true));



     }
}
