package ru.job4j.market;

public class Application {

    public int id;
    public String book;
    public String t;
    public String action;
    public int price;
    public int volume;

    public Application(int id, String book, String t, String action, int price, int volume) {
        this.id = id;
        this.book = book;
        this.t = t;
        this.action = action;
        this.price = price;
        this.volume = volume;
    }

    @Override
    public int hashCode() {
        int result = price != 0 ? price : 0;
        result = 31 * result + id;
        return result;
    }
}
