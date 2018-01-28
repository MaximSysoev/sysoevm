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
        userStore = new UserStore(new SimpleArray<Base>());
    }

    @Test
    public void whenAddNewUser() {
        Base base1 = new User("001");
        userStore.add(base1);
        assertThat("001", is(userStore.simpleArray.arrayList.get(0).getId()));
    }

    @Test
    public void whenRpelaceUsers() {
        Base base1 = new User("001");
        Base base2 = new User("002");
        userStore.add(base1);
        userStore.add(base2);
        userStore.replace(base1.getId(), base2);
        assertThat("002", is(userStore.simpleArray.arrayList.get(0).getId()));
    }

    @Test
    public void whenDeleteUsers() {
        Base base1 = new User("0");
        Base base2 = new User("1");
        userStore.add(base1);
        userStore.add(base2);
        userStore.delete(base1.getId());
        assertThat("1", is(userStore.simpleArray.arrayList.get(0).getId()));
    }

    @Test
    public void whenFindById() {
        Base base1 = new User("0");
        Base base2 = new User("1");
        Base base3 = new User("2");
        userStore.add(base1);
        userStore.add(base2);
        userStore.add(base3);
        assertThat("2", is(userStore.findById("2").getId()));
    }

}
