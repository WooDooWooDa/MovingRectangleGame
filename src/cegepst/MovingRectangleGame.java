package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.Game;
import cegepst.engine.controls.MovementController;

import java.awt.*;
import java.util.ArrayList;

public class MovingRectangleGame extends Game {

    private Player player;
    private GameController controller;
    private ArrayList<Footprint> footprints;

    public MovingRectangleGame() {
        controller = new GameController();
        player = new Player(controller);
        footprints = new ArrayList<>();
        super.addKeyListener(controller); //viens de game
    }

    @Override
    public void initialize() {

    }

    @Override
    public void conclude() {

    }

    @Override
    public void update() {
        if (controller.isQuitPressed()) {
            super.stop();
        }
        if (controller.isErasePressed()) {
            eraseFootPrint();
        }
        player.update();
        if (controller.isMoving()) {
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
