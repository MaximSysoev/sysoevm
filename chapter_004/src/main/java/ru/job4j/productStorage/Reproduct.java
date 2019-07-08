package ru.job4j.productStorage;

public abstract class Reproduct implements Actions {

    @Override
    public abstract boolean accept(Food food);

    @Override
    public abstract void add(Food food);
}
