/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom.projectiles;

import spaceshooter.dom.projectiles.Projectile;
import java.net.URL;
import javax.swing.ImageIcon;
import spaceshooter.dom.GameObject;
import spaceshooter.dom.Player;

/**
 * Projectile spawned by EnemyWeapon.
 *
 */
public class EnemyProjectile extends Projectile {

    /**
     * Constructor for EnemyProjectile.
     *
     * @param x x-coordinate.
     * @param y y-coordinate.
     * @param vx x-velocity.
     * @param vy y-velocity.
     * @param w Width of the hitbox.
     * @param h Height of the hitbox.
     * @param damage Damage of the projectile.
     */
    public EnemyProjectile(float x, float y, float vx, float vy, int w, int h, int damage) {
        super(x, y, vx, vy, w, h, damage);
        URL url = this.getClass().getResource("/Sprites/vihollisammus.png");
        ImageIcon icon = new ImageIcon(url);
        this.setSprite(icon.getImage());
    }

    @Override
    public void onCollision(GameObject obj) {
        if (obj instanceof Player) {
            this.setIsAlive(false);
        }
    }
}
