/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import spaceshooter.dom.enemys.Enemy;

/**
 *
 * @author Aleksi
 */
public class Spawner {

    private Enemy prototype;

    public Spawner(Enemy prototype) {
        this.prototype = prototype;
    }

    public Enemy spawnEnemy(float x, float y) {
        Enemy enemy = this.prototype.clone();
        enemy.setPosX(x);
        enemy.setPosY(y);
        return enemy;
    }
}
