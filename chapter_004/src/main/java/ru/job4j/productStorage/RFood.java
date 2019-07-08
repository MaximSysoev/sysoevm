package ru.job4j.productStorage;

import java.util.Date;

public class RFood extends Food {

    public RFood(String name, Date expaireDate, Date createDate, int price, int discont, boolean canReproduct) {
        super(name, expaireDate, createDate, price, discont, canReproduct);
    }

}
