package ru.job4j.productStorage;

public abstract class Reproduct implements Actions {

    protected Actions reproductAction;

    public Reproduct(Actions reproductAction) {
        this.reproductAction = reproductAction;
    }

    @Override
    public abstract boolean accept(Food food);

    @Override
    public abstract void add(Food food);
}
