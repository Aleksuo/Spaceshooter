package spaceshooter.dom;

import javax.swing.ImageIcon;

/**
 * Object that can be fired with a weapon. This object can iflict damage on
 * other objects it collides with.
 */
public class Projectile extends ImageObject {

    private int damage;

    /**
     * Constructor for Projectile.
     *
     * @param x x-coordinate.
     * @param y y-coordinate.
     * @param vx x-velocity.
     * @param vy y-velocity.
     * @param w width.
     * @param h height.
     * @param damage This projectiles damage value.
     */
    public Projectile(float x, float y, float vx, float vy, int w, int h, int damage) {
        super(x, y, vx, vy, w, h);
        this.setDamage(damage);
    }

    @Override
    public void update(Level taso) {
        move();
        if (this.getPosY() < 0) {
            this.setIsAlive(false);
        }
    }

    @Override
    public void move() {
        float dx = this.getPosX() + this.getVelX();
        float dy = this.getPosY() + this.getVelY();

        this.setPosY(dy);
        this.setPosX(dx);
    }

    public int getDamage() {
        return damage;
    }

    /**
     * Sets postive damage for this Projectile.
     *
     * @param damage Positive damage.
     */
    public void setDamage(int damage) {
        if (damage > 0) {
            this.damage = damage;
        }

    }

}
