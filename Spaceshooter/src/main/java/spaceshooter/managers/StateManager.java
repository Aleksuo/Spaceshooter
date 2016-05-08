/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.managers;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Stack;
import spaceshooter.input.KeyManager;
import spaceshooter.states.GameState;
import spaceshooter.states.MenuState;

/**
 * Manager that manages GameStates.
 *
 */
public class StateManager {

    private Stack<GameState> states;

    /**
     * Constructor for StateManager. Pushes a new MenuState.
     */
    public StateManager() {
        this.states = new Stack<GameState>();
        this.states.push(new MenuState(this));
    }

    /**
     * Pushes a new state to the stack.
     *
     * @param state Pushed state.
     */
    public void pushState(GameState state) {
        this.states.push(state);
    }

    /**
     * Pops a state from the stack.
     */
    public void popState() {
        this.states.pop();
    }

    /**
     * Renders the state on top of the stack.
     *
     * @param g Graphics object.
     */
    public void renderState(Graphics g) {
        if (!this.states.isEmpty()) {
            this.states.peek().render(g);
        }

    }

    /**
     * Ticks the state on top of the stack.
     */
    public void tickState() {
        if (!this.states.isEmpty()) {
            this.states.peek().tick();
        }

    }

    /**
     * Handles the input of the state on top of the stack.
     *
     * @param km Apps KeyManager.
     * @param point Current mouse position.
     */
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
