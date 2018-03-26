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

    public boolean contains(E value) {
        boolean result = false;
        for (E element : simpleArray.arrayList) {
            if (value == element) {
                result = true;
                break;
            }
        }
        return result;
    }


    public void add(E value) {
        if (!contains(value)) {
            simpleArray.add(value);
        }
    }
}
