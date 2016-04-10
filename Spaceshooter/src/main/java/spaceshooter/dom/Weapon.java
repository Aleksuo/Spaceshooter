/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import spaceshooter.util.Timer;

/**
 *
 * @author Aleksi
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
        this.firerate = firerate;
        this.damage = damage;
        this.lastFired = this.timer.elapsedTimeInSeconds();
    }

    public void shoot(Level taso) {
        double deltaTime = this.timer.elapsedTimeInSeconds() - lastFired;
        double rate = (1.0/ (double)firerate);
        System.out.println(deltaTime);
        System.out.println(rate);
        if (deltaTime > rate) {
            this.lastFired = timer.elapsedTimeInSeconds();
            float x = this.parent.getPosX() + 16;
            float y = this.parent.getPosY() - 10;
            taso.addObject(new Projectile(x, y, 10, 10, 10, 10, this.damage));
        }
    }
}
