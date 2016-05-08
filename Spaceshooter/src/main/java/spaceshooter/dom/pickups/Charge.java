package spaceshooter.dom.pickups;

import javax.swing.ImageIcon;
import spaceshooter.dom.ImageObject;

/**
 * Charge -pickup that gives player a charge on collision.
 *
 */
public class Charge extends ImageObject {

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
    public Charge(int x, int y, int vx, int vy, int w, int h) {
        super(x, y, vx, vy, w, h);
        ImageIcon icon = new ImageIcon("./Resources/Sprites/alus.png");
        this.setSprite(icon.getImage());
    }

}
