package cegepst;

import cegepst.engine.controls.MovementController;

import java.awt.event.KeyEvent;

public class GameController extends MovementController {

    private int quitKey = KeyEvent.VK_Q;
    private int eraseKey = KeyEvent.VK_E;

    public GameController() {
        super.bindKey(quitKey);
        super.bindKey(eraseKey);
    }

    public boolean isQuitPressed() {
        return isKeyPressed(quitKey);
    }

    public boolean isErasePressed() {
        return isKeyPressed(eraseKey);
    }
}
