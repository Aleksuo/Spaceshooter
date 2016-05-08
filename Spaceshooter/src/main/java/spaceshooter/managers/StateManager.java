/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.managers;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Stack;
import spaceshooter.spaceshooter.KeyManager;
import spaceshooter.states.GameState;
import spaceshooter.states.MenuState;

/**
 *
 * @author Aleksi
 */
public class StateManager {

    private Stack<GameState> states;

    public StateManager() {
        this.states = new Stack<GameState>();
        this.states.push(new MenuState(this));
    }

    public void pushState(GameState state) {
        this.states.push(state);
    }

    public void popState() {
        this.states.pop();
    }

    public void renderState(Graphics g) {
        if (!this.states.isEmpty()) {
            this.states.peek().render(g);
        }

    }

    public void tickState() {
        if (!this.states.isEmpty()) {
            this.states.peek().tick();
        }

    }

    public void handleStateInput(KeyManager km, Point point) {
        if (!this.states.isEmpty()) {
            this.states.peek().handleInput(km, point);
        }

    }

    public Stack<GameState> getStates() {
        return states;
    }

    public void setStates(Stack<GameState> states) {
        this.states = states;
    }

}
