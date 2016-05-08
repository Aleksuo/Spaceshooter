/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KeyListener for key input.
 *
 */
public class KeyManager implements KeyListener {

    private boolean[] keys;

    /**
     * Constructor for KeyManager.
     */
    public KeyManager() {
        this.keys = new boolean[256];
    }

    /**
     * Checks if key is pressed.
     *
     * @param keycode KeyEvent keycode.
     * @return Returns true if key is pressed else false.
     */
    public boolean isPressed(int keycode) {
        return keys[keycode];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.keys[e.getKeyCode()] = false;
    }

}
