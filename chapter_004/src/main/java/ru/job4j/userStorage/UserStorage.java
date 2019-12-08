package ru.job4j.userStorage;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ThreadSafe
public class UserStorage{

    @GuardedBy("this")
    public Map<Integer, User> users = new HashMap<Integer, User>();

    public synchronized boolean add(int id, User user) {
        if (!users.containsKey(id)) {
            users.put(id, user);
            return true;
        }
        return false;
    }

    public synchronized User getUserById(int id) {
        User user = new User();
        for (Map.Entry<Integer, User> item : users.entrySet()) {
            if (item.getValue().getId() == id) {
                user = item.getValue();
            }
        }
        return user;
    }

    public synchronized boolean update (User user) {
        User newUser =  getUserById(user.getId());
        if (newUser!=null) {
            newUser.setAmount(user.getAmount());
            return true;
        }
        return false;
    }

    public synchronized boolean delete(User user) {
        User newUser =  getUserById(user.getId());
        if (newUser!=null) {
            users.remove(user.getId());
            return true;
        }
        return false;
    }

    public synchronized void transfer(int fromId, int told, int amount) {
        User userFrom = getUserById(fromId);
        User userTold = getUserById(told);
        int difference = userFrom.getAmount() - amount;
        int sum = userTold.getAmount() + amount;
        if (difference > 0) {
            userFrom.setAmount(difference);
            userTold.setAmount(sum);
        } else {
            System.out.println("Недостаточно средств на счёте");
        }
    }

}
