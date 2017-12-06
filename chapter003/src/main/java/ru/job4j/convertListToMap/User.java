package ru.job4j.convertListToMap;

/**
 * Класс User описывает пользователя.
 */
public class User {

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
     * конструктор класса User.
     * @param id параметр.
     * @param name параметр.
     * @param city параметр.
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
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
     * Получить City.
     * @return city.
     */
    public String getCity() {
        return city;
    }

}
