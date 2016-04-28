/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import javax.swing.ImageIcon;
import spaceshooter.dom.enemys.Enemy;

/**
 *
 * @author Aleksi
 */
public class PlayerProjectile extends Projectile {

    public PlayerProjectile(float x, float y, float vx, float vy, int w, int h, int damage) {
        super(x, y, vx, vy, w, h, damage);
        ImageIcon icon = new ImageIcon("./Resources/Sprites/ammus.png");
        this.setSprite(icon.getImage());
    }
    
    @Override
    public void onCollision(GameObject obj) {
        if (obj instanceof Enemy) {
            this.setIsAlive(false);
        }
    }
    
}
