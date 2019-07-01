package ru.job4j.productStorage;

import java.util.Date;

public class RFood extends Food {

    private Actions rep;

    public RFood(Actions rep, String name, Date expaireDate, Date createDate, int price, int discont, boolean canReproduct) {
        super(name, expaireDate, createDate, price, discont, canReproduct);
        this.rep = rep;
    }

    public void add() {
        this.rep.add(this);
    }

}
