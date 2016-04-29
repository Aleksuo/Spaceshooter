package spaceshooter.states;

/**
 * Base for Gamestates.
 *
 */
abstract public class GameState {

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
    public abstract void render();

    /**
     * Handles current gamestates input.
     */
    public abstract void handleInput();
}
