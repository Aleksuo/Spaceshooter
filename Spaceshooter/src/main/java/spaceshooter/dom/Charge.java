package spaceshooter.dom;

/**
 * Charge -pickup that gives player a charge on collision.
 *
 */
public class Charge extends ImageObject implements IPickUp {

    public Charge(int x, int y, int vx, int vy, int w, int h) {
        super(x, y, vx, vy, w, h);
    }

}
