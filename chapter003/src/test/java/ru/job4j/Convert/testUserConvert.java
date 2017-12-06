package ru.job4j.Convert;
import org.junit.Test;
import ru.job4j.convertListToMap.User;
import ru.job4j.convertListToMap.UserConvert;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * testUserConvert класс.
 */
public class testUserConvert {
    /**
     * whenConvertMapToList - тестовый метод.
     */
    @Test
    public void whenConvertMapToList() {
        UserConvert userConvert = new UserConvert();
        List<User> list = new ArrayList<User>();
        User user = new User(1, "Maksim", "Arkhangelsk");
        list.add(user);
        HashMap<Integer, User> hm = userConvert.process(list);

        Set<Map.Entry<Integer, User>> set = hm.entrySet();
        for (Map.Entry<Integer, User> me : set) {
            assertThat(me.getValue().getName(), is("Maksim"));
        }

    }
}
