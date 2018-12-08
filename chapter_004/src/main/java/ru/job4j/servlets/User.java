package ru.job4j.servlets;

import java.util.Date;

public class User {

    public int id;
    public String name;
    public String login;
    public String email;
    public Date createDate;

    public User(int id, String name, String login, String email, Date createDate) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
    }

    public User() {

    }
}
