package ru.job4j.store;
import ru.job4j.simpeArray.*;

public abstract class AbstractStore<T extends Base> implements Store<T> {
    public SimpleArray<T> simpleArray = new SimpleArray<>();

    public AbstractStore(SimpleArray<T> simpleArray) {
        this.simpleArray = simpleArray;
    }

    @Override
    public void add(T model) {
        simpleArray.add((T)model);
    }

    @Override
    public void replace(String id, T model) {
        boolean result = true;
        int index = 0;
        while (index < simpleArray.arrayList.size()) {
            if (Integer.parseInt(id) == Integer.parseInt(simpleArray.get(index).getId())) {
                simpleArray.delete(index);
                simpleArray.set(Integer.parseInt(id), (T)model);
            }
            index++;
        }
    }

    public void delete(String id) {

        int i = 0;
        for (T element : simpleArray.arrayList) {
            if (id == simpleArray.arrayList.get(i).getId()) {
                simpleArray.delete(i);
                break;
            }
            i++;
        }
    }

    public T findById(String id) {

        int i = 0;
        T value = null;
        for (T element : simpleArray.arrayList) {
            if (id == simpleArray.arrayList.get(i).getId()) {
                value = simpleArray.get(i);
                break;
            }
            i++;
        }
        return value;
    }
}
