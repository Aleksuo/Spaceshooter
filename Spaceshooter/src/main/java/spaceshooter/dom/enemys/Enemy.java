package spaceshooter.dom.enemys;

import javax.swing.ImageIcon;
import java.util.Random;
import spaceshooter.dom.GameObject;

import spaceshooter.dom.ImageObject;

import spaceshooter.dom.Level;

import spaceshooter.dom.Player;

import spaceshooter.dom.PlayerProjectile;

import spaceshooter.dom.Projectile;

import spaceshooter.dom.Update;

/**
 * Abstract class for Enemy objects.
 *
 */
abstract public class Enemy extends ImageObject {

    private int hitpoints;
    private int score;

    /**
     * Constructor for Enemy object.
     *
     * @param x x-coordinate.
     * @param y y-coordinate.
     * @param vx x-velocity.
     * @param vy y-velocity.
     * @param w width.
     * @param h height.
     */
    public Enemy(float x, float y, float vx, float vy, int w, int h) {
        super(x, y, vx, vy, w, h);

    }

    @Override
    public void onDeath(Level level) {
        if (this.hitpoints == 0) {
            level.getScore().add(score);
            if (new Random().nextInt(10) == 1) {
                level.addObject(new Update(this.getPosX(), this.getPosY(), 10, 10, 32, 32));
            }
        }

    }

    @Override
    public void onCollision(GameObject obj) {
        if (obj instanceof PlayerProjectile) {
            Projectile projectile = (PlayerProjectile) obj;
            int newHp = this.getHitpoints() - projectile.getDamage();
            this.setHitpoints(newHp);

        }
        if (this.getHitpoints() <= 0) {
            this.setIsAlive(false);
        } else if (obj instanceof Player) {
            this.setIsAlive(false);
        }

    }

    public abstract Enemy clone();

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
