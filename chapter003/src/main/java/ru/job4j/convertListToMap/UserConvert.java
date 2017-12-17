package ru.job4j.convertlisttomap;
import java.util.*;

/**
 * Класс UserConvert.
 */
public class UserConvert {
    /**
     * HashMap - принимает список пользователей и конвертирует его в Map с ключем Integer id
     * и соответствующим ему User.
     * @param list - коллекция пользователей.
     * @return hm - параметр.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> hm = new HashMap<Integer, User>();
        for (User user : list) {
            hm.put(user.getId(), user);
        }
        return hm;
    }
}
