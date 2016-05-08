/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import spaceshooter.dom.enemys.Enemy;

/**
 * Spawner implemented using Prototype-pattern.
 */
public class Spawner {

    private Enemy prototype;

    /**
     * Constructor for Spawner.
     *
     * @param prototype Enemy this Spawner spawns.
     */
    public Spawner(Enemy prototype) {
        this.prototype = prototype;
    }

    /**
     * Returns a copy of the prototype given to this spawner.
     *
     * @param x x-coordinate.
     * @param y y-coordinate.
     * @return Returns a new enemy object.
     */
    public Enemy spawnEnemy(float x, float y) {
        Enemy enemy = this.prototype.clone();
        enemy.setPosX(x);
        enemy.setPosY(y);
        return enemy;
    }

    public Enemy getPrototype() {
        return prototype;
    }

    public void setPrototype(Enemy prototype) {
        this.prototype = prototype;
    }
    
    
}
