package ru.job4j.bank;
import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestOperations {
    @Test
    public void whenAddUser() {
        String result = "";
        Operations operation = new Operations();
        User user = new User("User1", "1111111");
        operation.addUser(user);
        for (User u : operation.hashMap.keySet()) {
            result = u.getName();
        }
        assertThat("User1", is(result));
    }

    @Test
    public void addAccountToUser() {
        List<Account> list = new ArrayList<Account>();
        Operations operation = new Operations();
        User user = new User("User1", "1234567");
        operation.addUser(user);
        Account account = new Account(10000, "requisitesUser1");
        operation.addAccountToUser("1234567", account);
        for (Map.Entry<User, List<Account>> entry : operation.hashMap.entrySet()) {
            list = entry.getValue();
        }
        assertThat(account.getRequisites(), is(list.get(0).getRequisites()));
    }

    @Test
    public void deleteAccountFromUser() {
        List<Account> result = new ArrayList<Account>();
        List<Account> expected = new ArrayList<Account>();
        Operations operation = new Operations();
        User user = new User("User1", "1234567");
        Account account = new Account(10000, "requisitesUser1");
        operation.addUser(user);
        operation.addAccountToUser("1234567", account);
        operation.deleteAccountFromUser("1234567", account);
        for (Map.Entry<User, List<Account>> entry : operation.hashMap.entrySet()) {
            result = entry.getValue();
        }
        assertThat(expected, is(result));
    }

    @Test
    public void whenGetUserAccounts() {
        List<Account> result = new ArrayList<Account>();
        Operations operation = new Operations();
        User user = new User("User1", "1234567");
        Account account = new Account(10000, "requisitesUser1");
        operation.addUser(user);
        operation.addAccountToUser("1234567", account);
        List<Account> expected = operation.getUserAccounts("1234567");
        assertThat("requisitesUser1", is(expected.get(0).getRequisites()));
    }

    @Test
    public void whenTransferMoney() {
        Operations operation = new Operations();
        User user1 = new User("User1", "1234567");
        User user2 = new User("User2", "7654321");
        Account accountUser1 = new Account(10000, "requisitesUser1");
        Account accountUser2 = new Account(1000, "requisitesUser2");
        operation.addUser(user1);
        operation.addUser(user2);
        operation.addAccountToUser("1234567", accountUser1);
        operation.addAccountToUser("7654321", accountUser2);
        boolean expected = operation.transferMoney("1234567", "requisitesUser1", "7654321", "requisitesUser2", 5000);
        assertThat(true, is(expected));
    }

}
