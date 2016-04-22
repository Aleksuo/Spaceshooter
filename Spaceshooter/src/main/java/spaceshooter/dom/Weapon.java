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
    private int upgrades;

    private Timer timer;
    private double lastFired;

    public Weapon(GameObject obj, int firerate, int damage) {
        this.parent = obj;
        this.timer = new Timer();
        this.setFirerate(firerate);
        this.setDamage(damage);
        this.lastFired = this.timer.elapsedTimeInSeconds();
        this.upgrades = 0;
    }

    /**
     * Creates projectiles on current level.
     *
     * @param taso Current Level
     */
    public void shoot(Level taso) {
        double deltaTime = this.timer.elapsedTimeInSeconds() - lastFired;
        double rate = (1.0 / (double) firerate);
        if (deltaTime > rate) {
            this.lastFired = timer.elapsedTimeInSeconds();
            float x = this.parent.getPosX() + 16;
            float y = this.parent.getPosY() - 10;
            taso.addObject(new Projectile(x, y, 0, -10, 10, 10, this.damage));
            if (upgrades > 0) {
                taso.addObject(new Projectile(x, y, -2, -10, 10, 10, this.damage));
            }
            if (upgrades > 1) {
                taso.addObject(new Projectile(x, y, 2, -10, 10, 10, this.damage));
            }
        }
    }

    /**
     * Increases upgrade count. More upgrades = more projectiles.
     */
    public void upgrade() {
        if (this.upgrades < 2) {
            this.upgrades++;
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

    public int getUpgrades() {
        return upgrades;
    }

    public void setUpgrades(int upgrades) {
        this.upgrades = upgrades;
    }

}
