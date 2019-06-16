package ru.job4j.productStorage;

import java.util.Date;

public class Food {

    private String name;
    private Date expaireDate;
    private Date createDate;
    private int price;
    private int discont;

    public Food(String name, Date expaireDate, Date createDate, int price, int discont) {
        this.name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.price = price;
        this.discont = discont;
    }

    public String getName() {
        return name;
    }

    public Date getExpaireDate() {
        return expaireDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscont() {
        return discont;
    }
}
