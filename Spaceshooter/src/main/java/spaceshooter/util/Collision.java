package spaceshooter.util;

import java.awt.Rectangle;

/**
 * Static class that is used to check collisions.
 *
 */
public final class Collision {

    /**
     * Checks collision between two rectangles using javas own rectangle class.
     *
     * @param rect1 hitbox of the first Object.
     * @param rect2 hitbox of the second Object.
     * @return Returns true if there is a collision or false if there is no
     * collision.
     */
    static public boolean isCollision(Rectangle rect1, Rectangle rect2) {
        return (rect1.intersects(rect2) && rect2.intersects(rect1));
    }
}
