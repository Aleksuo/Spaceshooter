package spaceshooter.states;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import spaceshooter.managers.Levelmanager;
import spaceshooter.managers.StateManager;
import spaceshooter.input.KeyManager;

/**
 * State that is used for gameplay.
 *
 */
public class GameplayState extends GameState {

    private Levelmanager levelManager;

    /**
     * Constructor for GameplayState.
     *
     * @param manager Apps StateManager.
     */
    public GameplayState(StateManager manager) {
        super(manager);
        entering();
    }

    @Override
    public void entering() {
        this.levelManager = new Levelmanager();
    }

    @Override
    public void leaving() {

    }

    @Override
    public void tick() {
        this.levelManager.tick();
        if (this.levelManager.checkIfIsOver()) {
            this.getStateManager().popState();
            this.getStateManager().pushState(new ResultState(this.getStateManager(), this.levelManager.getLevel().getScore().getScore()));
        }
    }

    @Override
    public void render(Graphics g) {
        this.levelManager.render(g);
    }

    @Override
    public void handleInput(KeyManager km, Point point) {
        this.levelManager.handleInput(km, point);
        if (km.isPressed(KeyEvent.VK_ESCAPE)) {
            this.getStateManager().popState();
        }
    }

}
