package ru.job4j.userStorageTest;

import ru.job4j.userStorage.User;
import ru.job4j.userStorage.UserStorage;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserStorageTest {

    private class ThreadUserStorage extends Thread {
        private final UserStorage storage;
        private final User user;
        private int id;

        public ThreadUserStorage(UserStorage storage, int id, User user) {
            this.storage = storage;
            this.id = id;
            this.user = user;
        }

        @Override
        public void run() {
            storage.add(id, user);
        }
    }

    @Test
    public void whenTransferUser() throws InterruptedException {
       final UserStorage store = new UserStorage();
        User user1 = new User(1, 100);
        User user2 = new User(2, 200);
        Thread first = new ThreadUserStorage(store, 1, user1);
        Thread second = new ThreadUserStorage(store, 2, user2);
        first.start();
        second.start();
        first.join();
        second.join();
        store.transfer(1, 2, 50);

        assertThat(store.users.get(2).getAmount(), is(250));

    }
}
