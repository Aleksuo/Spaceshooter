package spaceshooter.dom.pickups;

import java.net.URL;
import javax.swing.ImageIcon;
import spaceshooter.dom.ImageObject;

/**
 * Charge -pickup that gives player a charge on collision.
 *
 */
public class Charge extends Pickup {

    /**
     * Constructor for Charge-pickup.
     *
     * @param x x-coordinate.
     * @param y y-coordinate.
     * @param vx x-velocity.
     * @param vy y-velocity.
     * @param w width.
     * @param h height.
     */
    public Charge(float x, float y, float vx, float vy, int w, int h) {
        super(x, y, vx, vy, w, h);
        URL url = this.getClass().getResource("/Sprites/charge.png");
        ImageIcon icon = new ImageIcon(url);
        this.setSprite(icon.getImage());
    }

}
