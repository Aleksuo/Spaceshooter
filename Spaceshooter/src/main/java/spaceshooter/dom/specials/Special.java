/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom.specials;

import spaceshooter.dom.GameObject;
import spaceshooter.dom.Level;
import spaceshooter.util.Timer;

/**
 * Baseclass for Specials.
 *
 */
public class Special {

    private GameObject parent;
    private int charges;

    private Timer timer;
    private double lastFired;
    private double delay;

    /**
     * Constructor for Special.
     *
     * @param parent Parent of this Special.
     * @param delay Delay between uses.
     */
    public Special(GameObject parent, double delay) {
        this.parent = parent;
        this.charges = 3;
        this.delay = delay;
        this.timer = new Timer();
        this.lastFired = this.timer.elapsedTimeInSeconds();
    }

    /**
     * Triggers special.
     *
     * @param level Current level.
     */
    public void trigger(Level level) {
        if (this.getParent().isAlive() && this.charges > 0) {
            double deltaTime = this.timer.elapsedTimeInSeconds() - lastFired;
            if (deltaTime > this.delay) {
                this.lastFired = timer.elapsedTimeInSeconds();
                discharge();
                spawnSpecial(level);
            }
        }
    }

    /**
     * Spawns special to the level.
     *
     * @param level Current level.
     */
    public void spawnSpecial(Level level) {
    }

    /**
     * Decreases charges by one. Called when special is triggered.
     */
    public void discharge() {
        if (this.charges > 0) {
            this.charges--;
        }
    }

    /**
     * Increases charges by one.
     */
    public void charge() {
        if (this.charges < 3) {
            this.charges++;
        }
    }

    public GameObject getParent() {
        return parent;
    }

    public void setParent(GameObject parent) {
        this.parent = parent;
    }

    public int getCharges() {
        return charges;
    }

    public void setCharges(int charges) {
        this.charges = charges;
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

    public double getDelay() {
        return delay;
    }

    public void setDelay(double delay) {
        this.delay = delay;
    }
    
    

}
