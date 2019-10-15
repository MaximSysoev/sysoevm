package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private int ch = 1;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;

    }

    @Override
    public void run() {
        while (true) {
            this.rect.setX(this.rect.getX() + ch);
            if (this.rect.getX()>200) {
                    ch = -1;
            }
            if (this.rect.getX()<10) {
                ch = 1;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }

}
