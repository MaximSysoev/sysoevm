package ru.job4j.simpleSet;

import com.sun.xml.internal.fastinfoset.util.DuplicateAttributeVerifier;
import org.codehaus.classworlds.DuplicateRealmException;
import org.codehaus.plexus.DuplicateChildContainerException;
import ru.job4j.simpeArray.SimpleArray;

import java.util.DuplicateFormatFlagsException;

public class SimpleSet<E> {

   public SimpleArray<E> simpleArray;
    private int index = 0;

    public SimpleSet() {
        this.simpleArray = new SimpleArray<>();
    }

    public void add(E value) {
        int result = 0;
        for (E element : simpleArray.arrayList) {
            if (value == element) {
                result = 1;
                break;
            }
        }
        if (result == 0) {
            simpleArray.add(value);
        } else {
            throw new DuplicateFormatFlagsException(value.toString());
        }
    }
}
