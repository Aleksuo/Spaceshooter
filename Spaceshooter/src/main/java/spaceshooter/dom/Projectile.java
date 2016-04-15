package spaceshooter.dom;

import javax.swing.ImageIcon;

/**
 * Object that can be fired with a weapon. This object can iflict damage on
 * other objects it collides with.
 */
public class Projectile extends ImageObject {

    private int damage;

    public Projectile(float x, float y, float vx, float vy, int w, int h, int damage) {
        super(x, y, vx, vy, w, h);
        ImageIcon icon = new ImageIcon("./Resources/Sprites/ammus.png");
        this.setSprite(icon.getImage());
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
    public void onCollision(GameObject obj) {
        if (obj instanceof Enemy) {
            this.setIsAlive(false);
        }
    }

    public void move() {
        //float dx = this.getPosX() + this.getVelX();
        float dy = this.getPosY() - this.getVelY();

        this.setPosY(dy);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (damage > 0) {
            this.damage = damage;
        }

    }

}
