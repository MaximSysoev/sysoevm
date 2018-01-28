package ru.job4j.store;

import ru.job4j.simpeArray.SimpleArray;

public abstract class AbstractStore<T> implements Store {

    public SimpleArray<Base> simpleArray = new SimpleArray<>();

    public AbstractStore(SimpleArray<Base> simpleArray) {
        this.simpleArray = simpleArray;
    }

    public void add(Base model) {
        simpleArray.add(model);
    }

    public void replace(String id, Base model) {
        boolean result = true;
        int index = 0;
        while (index < simpleArray.arrayList.size()) {
            if (Integer.parseInt(id) == Integer.parseInt(simpleArray.get(index).getId())) {
                simpleArray.delete(index);
                simpleArray.set(Integer.parseInt(id), model);
            }
            index++;
        }
    }

    public void delete(String id) {
        simpleArray.delete(Integer.parseInt(id));
    }

    public Base findById(String id) {
        return simpleArray.get(Integer.parseInt(id));
    }
}
