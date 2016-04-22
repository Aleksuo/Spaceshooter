package spaceshooter.dom;

import javax.swing.ImageIcon;

/**
 * Charge -pickup that gives player a charge on collision.
 *
 */
public class Charge extends ImageObject  {

    public Charge(int x, int y, int vx, int vy, int w, int h) {
        super(x, y, vx, vy, w, h);
        ImageIcon icon = new ImageIcon("./Resources/Sprites/alus.png");
        this.setSprite(icon.getImage());
    }

}
