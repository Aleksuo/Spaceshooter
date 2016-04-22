package spaceshooter.spaceshooter;

import java.awt.Point;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import spaceshooter.dom.Level;
import spaceshooter.managers.Levelmanager;

/**
 * Base for an application.
 *
 */
public class App extends JFrame {

    private Levelmanager levelmanager;
    private boolean inGame;

    /**
     * Constructor for App.
     */
    public App() {
        this.initGUI();
        inGame = true;
    }

    /**
     * Initializes apps GUI.
     */
    public void initGUI() {
        this.levelmanager = new Levelmanager();
        this.add(levelmanager.getLevel());
        this.pack();
        this.setSize(800, 600);
        this.setTitle("Shmup");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        levelmanager.getLevel().requestFocus();

        this.setCursor(this.getToolkit().createCustomCursor(
                new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),
                "null"));

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

                this.levelmanager.tick();

                nextGameTick += 1000 / 15;
                loops++;

            }

        }

    }

}
