package ru.job4j.servlets.userstore;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty
    public int id;

    @JsonProperty
    public String name;

    @JsonProperty
    public String login;

    @JsonProperty("email")
    public String email;

    @JsonIgnore
    public Date createDate;

    @JsonProperty("password")
    private String password;

    @JsonProperty
    private String country;

    @JsonProperty
    private String city;

    @JsonIgnore
    private int role;

    public User() {}

    public User(int id, String name, String login, String email, Date createDate, String password, String country, String city, int role) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
        this.password = password;
        this.country = country;
        this.city = city;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
