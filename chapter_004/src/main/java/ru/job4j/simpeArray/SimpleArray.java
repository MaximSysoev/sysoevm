package ru.job4j.simpeArray;
import java.util.*;

public class SimpleArray<T> {
    ArrayList<T> arrayList = new ArrayList<T>();
    int index = 0;

    public void add(T value) {
        arrayList.add(value);
    }

    public void set(int index, T model) {
        arrayList.add(index, model);
    }

    public void delete(int index) {
        arrayList.remove(arrayList.get(index));
    }

    public T get(int index) {
        return arrayList.get(index);
    }


    public boolean hasNext() {
        int value = index + 1;
        boolean result = true;
        if (value <= arrayList.size()) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }


    public T next() {
       T value = null;
       if (index < arrayList.size()) {
           value = arrayList.get(index);
       } else {
           throw new NoSuchElementException();
       }
       index++;
       return value;
    }

    public static void main(String[] args) {
        SimpleArray<Integer> simpleArray = new SimpleArray<Integer>();
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        System.out.println(simpleArray.next());
        System.out.println(simpleArray.next());
        System.out.println(simpleArray.next());
        System.out.println(simpleArray.hasNext());
    }
}
