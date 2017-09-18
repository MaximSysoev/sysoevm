package ru.job4j.condition;

public class Point {
    private int x;
    private int y;

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean is(int a, int b) {
        boolean result = y==x*a+b ? true : false;
        return result;
    }

}
