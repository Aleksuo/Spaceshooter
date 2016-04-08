/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.util;

import java.awt.Rectangle;

/**
 *
 * @author Aleksi
 */
public final class Collision {

    static public boolean isCollision(Rectangle rect1, Rectangle rect2) {
        return (rect1.intersects(rect2)&&rect2.intersects(rect1));
    }
}
