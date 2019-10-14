package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private int sign;

    public RectangleMove(Rectangle rect, int sign) {
        this.rect = rect;
        this.sign = sign;
    }

    @Override
    public void run() {
        while (true) {
            this.rect.setX(this.rect.getX() + this.sign);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
