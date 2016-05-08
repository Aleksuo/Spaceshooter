package spaceshooter.states;

import java.awt.Graphics;
import java.awt.Point;
import spaceshooter.managers.StateManager;
import spaceshooter.spaceshooter.KeyManager;

/**
 * Base for Gamestates.
 *
 */
abstract public class GameState {

    private StateManager stateManager;

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
     * Renders current gamestate to the screen.
     */
    public abstract void render(Graphics g);

    /**
     * Handles current gamestates input.
     */
    public abstract void handleInput(KeyManager km, Point point);

    public StateManager getStateManager() {
        return stateManager;
    }

    public void setStateManager(StateManager stateManager) {
        this.stateManager = stateManager;
    }

}
