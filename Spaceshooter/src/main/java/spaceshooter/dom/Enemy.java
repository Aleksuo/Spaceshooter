package spaceshooter.dom;

import javax.swing.ImageIcon;

/**
 * Abstract class for Enemy objects.
 *
 */
abstract public class Enemy extends ImageObject {

    private int hitpoints;

    public Enemy(float x, float y, float vx, float vy, int w, int h) {
        super(x, y, vx, vy, w, h);

    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

}
