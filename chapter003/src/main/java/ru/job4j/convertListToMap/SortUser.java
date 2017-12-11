package ru.job4j.convertListToMap;
import java.util.*;

/**
 * Класс Sortuser.
 */
public class SortUser {

    /**
     * Метод sort - сортирует список.
     * @param list параметр - входящая коллекция.
     * @return set.
     */
    public Set<User> sort (List<User> list) {
        TreeSet<User> set = new TreeSet<User>(list);
        return set;
    }

}
