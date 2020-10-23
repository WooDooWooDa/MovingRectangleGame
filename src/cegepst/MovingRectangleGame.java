package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.Game;

import java.awt.*;
import java.util.ArrayList;

public class MovingRectangleGame extends Game {

    private Player player;
    private InputHandler inputHandler;
    private ArrayList<Footprint> footprints;

    public MovingRectangleGame() {
        inputHandler = new InputHandler();
        player = new Player(inputHandler);
        footprints = new ArrayList<>();
        super.addKeyListener(inputHandler); //viens de game
    }

    @Override
    public void initialize() {

    }

    @Override
    public void conclude() {

    }

    @Override
    public void update() {
        if (inputHandler.isQuitPressed()) {
            super.stop();
        }
        if (inputHandler.isErased()) {
            eraseFootPrint();
        }
        player.update();
        if (inputHandler.isMoving()) {
            footprints.add(player.layFootPrint());
        }
    }

    @Override
    public void draw(Buffer buffer) {
        for (Footprint footprint : footprints) {
            footprint.draw(buffer);
        }
        player.draw(buffer);
        buffer.drawText("Press Q to quit", 20, 20, Color.WHITE);
        buffer.drawText("Press E to erase footprints", 20, 40, Color.WHITE);
    }

    private void eraseFootPrint() {
        footprints.clear();
    }
}
