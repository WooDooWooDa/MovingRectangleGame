package cegepst;

import cegepst.engine.Buffer;

import java.awt.*;
import java.util.Random;

public class Footprint {

    private int x;
    private int y;
    private int height = 5;
    private int width = 5;

    public Footprint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Buffer buffer) {
        Color color = new Color(getRandomColor(), getRandomColor(), getRandomColor());
        buffer.drawRectangle(x, y, width, height, color);
    }

    private int getRandomColor() {
        return (new Random().nextInt(256));
    }
}
