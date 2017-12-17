package ru.job4j.convert;
import org.junit.Test;
import ru.job4j.convertlisttomap.*;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестовый класс testSortUser.
 */
public class TestSortUser {
    /**
     * Тестовый метод для создания сортировочного массива.
     */
   /* @Test
    public void whenCreateSortList() {
        Set<User> users = new TreeSet<>();
        Set<User> expect = new TreeSet<>();
        SortUser sortUser = new SortUser();
        ArrayList<User> al = new ArrayList<User>();
        al.addAll(
            Arrays.asList(
                 new User(0, "User1", "City1", 30),
                 new User(1, "User2", "City2", 29),
                 new User(2, "User3", "City3", 28),
                 new User(3, "User4", "City4", 32)
            )
        );
        expect.addAll(
            Arrays.asList(
                    new User(0, "User1", "City1", 30),
                    new User(1, "User2", "City2", 29),
                    new User(2, "User3", "City3", 28),
                    new User(3, "User4", "City4", 32)
            )
        );
        assertThat(sortUser.sort(al), is(expect));
    }*/
}
