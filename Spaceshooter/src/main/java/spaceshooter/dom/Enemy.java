/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import javax.swing.ImageIcon;

/**
 *
 * @author Aleksi
 */
public class Enemy extends ImageObject {
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
