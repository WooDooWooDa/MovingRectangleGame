package cegepst;

import cegepst.engine.Buffer;

import java.awt.*;

public class Player {

    private int x;
    private int y;
    private int width = 30;
    private int height = 60;
    private int speed = 4;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update(InputHandler handler) {
        if (handler.isDownPressed()) {
            y += speed;
        } else if (handler.isUpPressed()) {
            y -= speed;
        } else if (handler.isLeftPressed()) {
            x -= speed;
        } else if (handler.isRightPressed()) {
            x += speed;
        }
    }

    public void draw(Buffer buffer) {
        buffer.drawRectangle(x, y, width, height, Color.white);
    }

}
