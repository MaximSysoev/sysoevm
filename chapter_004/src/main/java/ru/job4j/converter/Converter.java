package ru.job4j.converter;
import java.util.*;

public class Converter {

   public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
       return new Iterator<Integer>() {
           Iterator<Integer> iterator = it.next();

           @Override
           public boolean hasNext() {
               boolean result = false;
                   if (iterator.hasNext()) {
                       result = iterator.hasNext();
                   } else {
                       result = it.hasNext();
                   }
               return result;
           }

           @Override
           public Integer next() {
                int value = 0;
                if (iterator.hasNext()) {
                    value = iterator.next();
                } else {
                    iterator = it.next();
                    value = iterator.next();
                }
                return value;
           }
       };
   }

}
