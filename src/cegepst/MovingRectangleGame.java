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
        if (inputHandler.isDownPressed()) {
            player.setY(player.getY() + 4);
        } else if (inputHandler.isUpPressed()) {
            player.setY(player.getY() - 4);
        } else if (inputHandler.isLeftPressed()) {
            player.setX(player.getX() - 4);
        } else if (inputHandler.isRightPressed()) {
            player.setX(player.getX() + 4);
        } else if (inputHandler.isQuitPressed()) {
            super.stop();
        }
    }

    @Override
    public void draw(Buffer buffer) {
        buffer.drawRectangle(player.getX(), player.getY(), player.getWidth(), player.getHeight(), Color.white);
    }
}
