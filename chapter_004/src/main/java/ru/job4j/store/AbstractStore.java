package ru.job4j.store;

import ru.job4j.simpeArray.SimpleArray;

public abstract class AbstractStore<T extends Base> implements Store {

    public SimpleArray<T> simpleArray = new SimpleArray<>();

    public AbstractStore(SimpleArray<T> simpleArray) {
        this.simpleArray = simpleArray;
    }

    public void add(Object model) {
        simpleArray.add((T) model);
    }

    public void replace(String id, Object model) {
        boolean result = true;
        int index = 0;
        while (index < simpleArray.arrayList.size()) {
            if (Integer.parseInt(id) == Integer.parseInt(simpleArray.get(index).getId())) {
                simpleArray.delete(index);
                simpleArray.set(Integer.parseInt(id), (T) model);
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
