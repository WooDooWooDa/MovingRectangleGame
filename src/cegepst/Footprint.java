package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.entities.StaticEntity;

import java.awt.*;
import java.util.Random;

public class Footprint extends StaticEntity {

    private Color color;

    public Footprint(int x, int y) {
        teleport(x, y);
        setDimension(5, 5);
        color = getRandomColor();
    }

    public void draw(Buffer buffer) {
        buffer.drawRectangle(x, y, width, height, color);
    }

    private Color getRandomColor() {
        Random random = new Random();
        return (new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
    }
}
