package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.entities.StaticEntity;

import java.awt.*;
import java.util.Random;

public class Footprint extends StaticEntity {

    public Footprint(int x, int y) {
        teleport(x, y);
        setDimension(5, 5);
    }

    public void draw(Buffer buffer) {
        buffer.drawRectangle(x, y, width, height, new Color(getRandomColor(), getRandomColor(), getRandomColor()));
    }

    private int getRandomColor() {
        return (new Random().nextInt(256));
    }
}
