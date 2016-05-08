/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.states;

import com.sun.glass.events.KeyEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import spaceshooter.managers.StateManager;
import spaceshooter.spaceshooter.KeyManager;

/**
 *
 * @author Aleksi
 */
public class ResultState extends GameState {

    private int score;

    public ResultState(StateManager manager, int score) {
        super(manager);
        this.score = score;
    }

    @Override
    public void entering() {

    }

    @Override
    public void leaving() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setFont(new Font("TimeRoman", Font.BOLD, 30));
        g.drawString("Your final score: " + this.score, 250, 250);
        g.setFont(new Font("TimeRoman", Font.PLAIN, 20));
        g.drawString("Press R to retry", 300, 300);
        g.drawString("Press M to return to the Menu", 300, 320);
    }

    @Override
    public void handleInput(KeyManager km, Point point) {
        if (km.isPressed(KeyEvent.VK_R)) {
            this.getStateManager().pushState(new GameplayState(this.getStateManager()));
        } else if (km.isPressed(KeyEvent.VK_M)) {
            this.getStateManager().popState();
        }

    }

}
