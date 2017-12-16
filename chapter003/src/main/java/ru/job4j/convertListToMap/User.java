package ru.job4j.convertlisttomap;
import java.lang.*;
import java.util.Comparator;

/**
 * Класс User описывает пользователя.
 */
public class User<User> {

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
    private int age;

    /**
     * конструктор класса User.
     * @param id параметр.
     * @param name параметр.
     * @param city параметр.
     */
    public User(int id, String name, String city, int age) {
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
    public int getAge() {
        return age;
    }
 }

/**
 * PersonNameComparator - определяет компаратор для длины имени.
 */
class PersonNameComparator implements Comparator<User> {
    @Override
    public int compare(User a, User b) {
        return a.getName().compareTo(b.getName());
    }
}

/**
 * PersonAgeComparator - определяет компоратор для имени.
 */
class PersonAgeComparator implements Comparator<User> {
    @Override
    public int compare(User a, User b) {
        if (a.getAge() > b.getAge()) {
            return 1;
        } else if (a.getAge() < b.getAge()) {
            return -1;
        } else {
            return 0;
        }
    }
}