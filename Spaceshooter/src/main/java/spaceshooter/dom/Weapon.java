package spaceshooter.dom;

import spaceshooter.util.Timer;

/**
 * This class is used to create instances of projectiles. Firerate affects the
 * rate at which this object can spawn proctiles. Damage is the damage given to
 * spawned projectiles
 *
 */
public class Weapon {

    private GameObject parent;

    private int firerate;
    private int damage;

    private Timer timer;
    private double lastFired;

    public Weapon(GameObject obj, int firerate, int damage) {
        this.parent = obj;
        this.timer = new Timer();
        this.setFirerate(firerate);
        this.setDamage(damage);
        this.lastFired = this.timer.elapsedTimeInSeconds();
    }

    public void shoot(Level taso) {
        double deltaTime = this.timer.elapsedTimeInSeconds() - lastFired;
        double rate = (1.0 / (double) firerate);
        System.out.println(deltaTime);
        System.out.println(rate);
        if (deltaTime > rate) {
            this.lastFired = timer.elapsedTimeInSeconds();
            float x = this.parent.getPosX() + 16;
            float y = this.parent.getPosY() - 10;
            taso.addObject(new Projectile(x, y, 10, 10, 10, 10, this.damage));
        }
    }

    public GameObject getParent() {
        return parent;
    }

    public void setParent(GameObject parent) {
        this.parent = parent;
    }

    public int getFirerate() {
        return firerate;
    }

    public void setFirerate(int firerate) {
        if (firerate > 0) {
            this.firerate = firerate;
        }

    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (damage > 0) {
            this.damage = damage;
        }

    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public double getLastFired() {
        return lastFired;
    }

    public void setLastFired(double lastFired) {
        this.lastFired = lastFired;
    }

}
