package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MovingRectangleGame extends Game {

    private Player player1;
    private Player player2;
    private GameController controllerP1;
    private GameController controllerP2;
    private ArrayList<Footprint> footprints;

    public MovingRectangleGame() {
        footprints = new ArrayList<>();
        controllerP1 = new GameController();
        controllerP2 = new GameController();
        player1 = new Player(controllerP1, Color.RED);
        player2 = new Player(controllerP2, Color.BLUE);
        setControlKeys(controllerP2);
        super.addKeyListener(controllerP1);
        super.addKeyListener(controllerP2); //viens de game
    }

    @Override
    public void initialize() {

    }

    @Override
    public void conclude() {

    }

    @Override
    public void update() {
        if (controllerP1.isQuitPressed()) {
            super.stop();
        }
        if (controllerP1.isErasePressed()) {
            eraseFootPrint();
        }
        player1.update();
        player2.update();
        if (controllerP1.isMoving()) {
            footprints.add(player1.layFootPrint());
        }
        if (controllerP2.isMoving()) {
            footprints.add(player2.layFootPrint());
        }
    }

    @Override
    public void draw(Buffer buffer) {
        for (Footprint footprint : footprints) {
            footprint.draw(buffer);
        }
        player1.draw(buffer);
        player2.draw(buffer);
        buffer.drawText("Press Q to quit", 20, 20, Color.WHITE);
        buffer.drawText("Press E to erase footprints", 20, 40, Color.WHITE);
    }

    private void setControlKeys(GameController controller) {
        controller.setUpKey(KeyEvent.VK_W);
        controller.setDownKey(KeyEvent.VK_S);
        controller.setLeftKey(KeyEvent.VK_A);
        controller.setRightKey(KeyEvent.VK_D);
    }

    private void eraseFootPrint() {
        footprints.clear();
    }
}
