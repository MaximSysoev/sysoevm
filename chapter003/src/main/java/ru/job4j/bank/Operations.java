package ru.job4j.bank;
import java.util.*;

public class Operations {
     Map<User, List<Account>> hashMap = new HashMap<>();

    public void addUser(User user) {
        hashMap.put(user, null);
    }

    public void deleteUser(User user) {
        hashMap.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        List<Account> al = new ArrayList<Account>();
        for (Map.Entry<User, List<Account>> entry : hashMap.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                if (entry.getValue() == null) {
                    al.add(account);
                    entry.setValue(al);
                } else {
                    al = entry.getValue();
                    al.add(account);
                    entry.setValue(al);
                }
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        List<Account> al = new ArrayList<Account>();
        for (Map.Entry<User, List<Account>> entry : hashMap.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                if (entry.getValue() != null) {
                    al = entry.getValue();
                    al.remove(account);
                } else {

                }
            }
        }
    }

    public List<Account> getUserAccounts (String passport) {
        List<Account> list = new ArrayList<Account>();
        for (Map.Entry<User, List<Account>> entry : hashMap.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
               list.addAll(entry.getValue());
            }
        }
        return list;
    }

    public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = true;
        for (Account account : this.getUserAccounts(srcPassport)) {
            if (account.getRequisites().equals(srcRequisite) && account.getValue() > amount) {
                account.setValue(account.getValue() - amount);
            } else {
                result = false;
             }
         }

         for (Account account : this.getUserAccounts(destPassport)) {
            if (account.getRequisites().equals(dstRequisite)) {
                account.setValue(account.getValue() + amount);
            }
         }
        return result;
    }
}
