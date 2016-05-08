/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom.pickups;

import javax.swing.ImageIcon;
import java.lang.*;
import java.net.URL;
import spaceshooter.dom.GameObject;
import spaceshooter.dom.ImageObject;
import spaceshooter.dom.Level;
import spaceshooter.dom.Player;

/**
 * Update -pickup that updates players weapon on collision.
 *
 */
public class Update extends Pickup {

    /**
     * Constructor for Update.
     *
     * @param x x-coordinate.
     * @param y y-coordinate.
     * @param vx x-velocity.
     * @param vy y-velocity.
     * @param w width.
     * @param h height.
     */
    public Update(float x, float y, float vx, float vy, int w, int h) {
        super(x, y, vx, vy, w, h);
        URL url = this.getClass().getResource("/Sprites/update.png");
        ImageIcon icon = new ImageIcon(url);
        this.setSprite(icon.getImage());
    }

}
