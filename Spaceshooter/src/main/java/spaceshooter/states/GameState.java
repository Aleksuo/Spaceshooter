package spaceshooter.states;

import java.awt.Graphics;
import java.awt.Point;
import spaceshooter.managers.StateManager;
import spaceshooter.input.KeyManager;

/**
 * Base for Gamestates.
 *
 */
abstract public class GameState {

    private StateManager stateManager;

    /**
     * Constructor for GameState.
     *
     * @param manager Apps StateManager.
     */
    public GameState(StateManager manager) {
        this.stateManager = manager;
    }

    /**
     * Excecuted when gamestate is entered.
     */
    public abstract void entering();

    /**
     * Excecuted when leving gamestate.
     */
    public abstract void leaving();

    /**
     * Called every frame. Updates current gamestate.
     */
    public abstract void tick();

    /**
     * Renders this state.
     *
     * @param g Graphics object.
     */
    public abstract void render(Graphics g);

    /**
     * Handles states input.
     *
     * @param km Apps KeyManager.
     * @param point Curren mouse position.
     */
    public abstract void handleInput(KeyManager km, Point point);

    public StateManager getStateManager() {
        return stateManager;
    }

    public void setStateManager(StateManager stateManager) {
        this.stateManager = stateManager;
    }

}
