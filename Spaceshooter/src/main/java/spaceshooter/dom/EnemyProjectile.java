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
public class EnemyProjectile extends Projectile {

    public EnemyProjectile(float x, float y, float vx, float vy, int w, int h, int damage) {
        super(x, y, vx, vy, w, h, damage);
        ImageIcon icon = new ImageIcon("./Resources/Sprites/vihollisammus.png");
        this.setSprite(icon.getImage());
        this.setDamage(damage);
    }

    @Override
    public void onCollision(GameObject obj) {
        if (obj instanceof Player) {
            this.setIsAlive(false);
        }
    }
}
