package ru.job4j.userStorage;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.util.ArrayList;
import java.util.List;

@ThreadSafe
public class UserStorage{



    @GuardedBy("this")
    public List<User> list = new ArrayList<>();

    public synchronized boolean add(User user) {
        if (list.add(user)) {
            return true;
        }
        return false;
    }

    public synchronized int getUserById(int id) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                //user = list.get(i);
                index = i;
                break;
            }
        }
        return index;
    }

    public synchronized boolean update (User user) {
        int userId = getUserById(user.getId());
        if (userId!=-1) {
            list.get(userId).setId(user.getId());
            list.get(userId).setAmount(user.getAmount());
            return true;
        }
        return false;
    }

    public synchronized boolean delete(User user) {
        int userId = getUserById(user.getId());
        if (userId!=-1) {
            list.remove(userId);
            return true;
        }
        return false;
    }

    public synchronized void transfer(int fromId, int told, int amount) {
        int userFromId = getUserById(fromId);
        int userToldId = getUserById(told);
        User userFrom = list.get(userFromId);
        User userTold = list.get(userToldId);
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
