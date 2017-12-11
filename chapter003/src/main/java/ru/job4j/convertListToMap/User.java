package ru.job4j.convertListToMap;
import java.lang.*;

/**
 * Класс User описывает пользователя.
 */
public class User implements Comparable<User> {

    /**
     * id пользователя.
     */
    private int id;

    /**
     * name - имя пользователя.
     */
    private String name;

    /**
     * city - город.
     */
    private String city;

    /**
     * age - возраст.
     */
    private String age;

    public User() {

    }

    /**
     * конструктор класса User.
     * @param id параметр.
     * @param name параметр.
     * @param city параметр.
     */
    public User(int id, String name, String city, String age) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.age = age;
    }

    /**
     * Получить id.
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * Получить name.
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Получить city.
     * @return city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Получить age.
     * @return age.
     */
    public String getAge() {
        return age;
    }

    /**
     * Переопределён метод compareTo - сортирует пользователей по возрасту.
     * @param o воходящий User;
     * @return параметр age, отсортированный по возрастанию.
     */
    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.age);
    }

    /**
     * Переопределён метод toString().
     * @return Вывод информации.
     */
    @Override
    public String toString() {
        return "USERS {name='" + name + "' age='" + age +"'}";
    }
}
