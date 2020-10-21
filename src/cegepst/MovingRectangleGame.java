package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.Game;

import java.awt.*;

public class MovingRectangleGame extends Game {

    private Player player;
    private InputHandler inputHandler;

    public MovingRectangleGame() {
        player = new Player(100, 100);
        inputHandler = new InputHandler();
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
        player.update(inputHandler);
    }

    @Override
    public void draw(Buffer buffer) {
        buffer.drawText("Press Q to quit", 20, 15, Color.WHITE);
        player.draw(buffer);
    }
}
