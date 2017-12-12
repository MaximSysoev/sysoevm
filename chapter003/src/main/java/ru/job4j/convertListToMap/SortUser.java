package ru.job4j.convertListToMap;
import javax.jws.soap.SOAPBinding;
import java.util.*;

/**
 * Класс SortUser.
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

    /**
     * Метод сортирует по лине имени.
     * @param list коллекция.
     * @return list.
     */
    public List<User> sortNameLength(List<User> list) {
        list.sort(new PersonNameComparator());
        return list;
    }

    /**
     * Метод сортирует по возрасту.
     * @param list коллекиця.
     * @return list.
     */
    public List<User> sortByAllFields (List<User> list) {
        list.sort(new PersonNameComparator().thenComparing(new PersonAgeComparator()));
        return list;
    }

}
