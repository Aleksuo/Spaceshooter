package spaceshooter.spaceshooter;

import spaceshooter.input.KeyManager;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import spaceshooter.dom.Level;
import spaceshooter.gui.Window;
import spaceshooter.managers.Levelmanager;
import spaceshooter.managers.StateManager;
import spaceshooter.states.GameState;
import spaceshooter.states.GameplayState;
import spaceshooter.states.MenuState;

/**
 * Base for an application.
 *
 */
public class App {

    private Window window;
    private KeyManager keymanager;
    private StateManager statemanager;

    private boolean inGame;

    /**
     * Constructor for App.
     */
    public App() {
        this.initGUI();
        inGame = true;
        this.keymanager = new KeyManager();
        this.statemanager = new StateManager();
        this.window.getFrame().addKeyListener(keymanager);
    }

    /**
     * Initializes apps GUI.
     */
    public void initGUI() {
        this.window = new Window(800, 640);

    }

    private void render() {
        BufferStrategy bs = window.getCanvas().getBufferStrategy();
        if (bs == null) {
            window.getCanvas().createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.clearRect(0, 0, this.window.getWidth(), this.window.getHeight());

        this.statemanager.renderState(g);

        bs.show();
        g.dispose();
    }

    /**
     * Loop that updates apps current state.
     */
    public void loop() {
        double nextGameTick = System.currentTimeMillis();
        int loops;

        while (inGame) {
            loops = 0;
            while (System.currentTimeMillis() > nextGameTick
                    && loops < 5) {

                if (!this.statemanager.getStates().isEmpty()) {
                    this.statemanager.handleStateInput(this.keymanager, this.window.getFrame().getMousePosition());

                    this.statemanager.tickState();
                    render();
                } else {
                    this.inGame = false;
                    this.window.getFrame().dispatchEvent(new WindowEvent(this.window.getFrame(), WindowEvent.WINDOW_CLOSING));
                }

                nextGameTick += 1000 / 15;
                loops++;

            }

        }

    }

}
