package ru.job4j.converter;
import java.util.*;

public class Converter {
    ArrayList<Integer> arrayList = new ArrayList<>();

    public ArrayList<Integer> convertToList(Iterator<Integer> iterator) {
        while (iterator.hasNext()) {
            arrayList.add(iterator.next());
        }
        return arrayList;
    }

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        while (it.hasNext()) {
            convertToList(it.next());
        }

        Iterator<Integer> iterator = arrayList.iterator();

        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return iterator.next();
            }
        };
    }

}
