package spaceshooter.states;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.ImageIcon;

import spaceshooter.managers.StateManager;
import spaceshooter.input.KeyManager;

/**
 * State that is used when in menu.
 *
 */
public class MenuState extends GameState {

    private Image background;

    /**
     * Constructor for MenuState.
     *
     * @param manager Apps StateManager.
     */
    public MenuState(StateManager manager) {
        super(manager);

        URL url = this.getClass().getResource("/Sprites/background.png");
        ImageIcon icon = new ImageIcon(url);
        this.background = icon.getImage();

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
        g.drawImage(background, 0, 0, null);
        g.setFont(new Font("ComicSans", Font.BOLD, 50));
        g.drawString("SPACESHOOTER", 200, 100);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("Press G to start the game", 300, 320);
        g.drawString("        or ", 300, 340);
        g.drawString("Press Escape to exit the game", 300, 360);
    }

    @Override
    public void handleInput(KeyManager km, Point point) {
        if (km.isPressed(KeyEvent.VK_G)) {
            this.getStateManager().pushState(new GameplayState(this.getStateManager()));
        } else if (km.isPressed(KeyEvent.VK_ESCAPE)) {
            this.getStateManager().popState();
        }
    }

}
