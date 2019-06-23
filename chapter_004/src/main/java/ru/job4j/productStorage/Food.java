package ru.job4j.productStorage;

import java.util.Date;

public class Food {
    private String name;
    private Date expaireDate;
    private Date createDate;
    private int price;
    private int discont;
    boolean canReproduct;

    public Food(String name, Date expaireDate, Date createDate, int price, int discont, boolean canReproduct) {
        this.name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.price = price;
        this.discont = discont;
        this.canReproduct = canReproduct;
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

    public void setDiscont(int discont) {
        this.discont = discont;
    }

    public boolean isCanReproduct() {
        return canReproduct;
    }

    public void setCanReproduct(boolean canReproduct) {
        this.canReproduct = canReproduct;
    }
}
