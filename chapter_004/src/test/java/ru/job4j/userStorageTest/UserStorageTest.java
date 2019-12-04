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

        public ThreadUserStorage(UserStorage storage, User user) {
            this.storage = storage;
            this.user = user;
        }

        @Override
        public void run() {
            storage.add(this.user);
        }

        public UserStorage getStorage() {
            return storage;
        }
    }

    @Test
    public void whenTransferUser() throws InterruptedException {
       final UserStorage store = new UserStorage();
        User user1 = new User(1, 100);
        User user2 = new User(2, 200);
        Thread first = new ThreadUserStorage(store, user1);
        Thread second = new ThreadUserStorage(store, user2);
        first.start();
        second.start();
        first.join();
        second.join();
        store.transfer(1, 2, 50);

        assertThat(store.list.get(0).getAmount(), is(50));

    }
}
