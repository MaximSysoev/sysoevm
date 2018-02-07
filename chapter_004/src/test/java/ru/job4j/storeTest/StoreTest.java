package job4j.storeTest;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.simpeArray.SimpleArray;
import ru.job4j.store.Base;
import ru.job4j.store.User;
import ru.job4j.store.UserStore;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StoreTest {
    private UserStore userStore;

    @Before
    public void setUp(){
        userStore = new UserStore();
    }

    @Test
    public void whenAddNewUser() {
        User user = new User("001");
        userStore.add(user);
        assertThat("001", is(userStore.simpleArray.arrayList.get(0).getId()));
    }

    @Test
    public void whenRpelaceUsers() {
        User user1 = new User("001");
        User user2 = new User("002");
        userStore.add(user1);
        userStore.add(user2);
        userStore.replace(user1.getId(), user2);
        assertThat("002", is(userStore.simpleArray.arrayList.get(0).getId()));
    }

    @Test
    public void whenDeleteUsers() {
        User user1 = new User("0");
        User user2 = new User("1");
        userStore.add(user1);
        userStore.add(user2);
        userStore.delete(user1.getId());
        assertThat("1", is(userStore.simpleArray.arrayList.get(0).getId()));
    }

    @Test
    public void whenFindById() {
        User user = new User("1");
        userStore.add(user);
        assertThat("1", is(userStore.findById("1").getId()));
    }

}
