/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom.enemys;

import java.net.URL;
import javax.swing.ImageIcon;
import spaceshooter.dom.enemys.Enemy;
import spaceshooter.dom.EnemyWeapon;
import spaceshooter.dom.GameObject;
import spaceshooter.dom.Level;
import spaceshooter.dom.Weapon;

/**
 * Enemy that moves and shoots projectiles towards the player.
 *
 */
public class Saucer extends Enemy {

    private int tick = 0;

    private Weapon weapon;

    /**
     * Constructor for Saucer object.
     *
     * @param x x-coordinate.
     * @param y y-coordinate.
     * @param vx x-velocity.
     * @param vy y-velocity.
     * @param w width.
     * @param h height.
     */
    public Saucer(float x, float y, float vx, float vy, int w, int h) {
        super(x, y, vx, vy, w, h);
        this.weapon = new EnemyWeapon(this, 2, 25);
        URL url = this.getClass().getResource("/Sprites/Saucer.png");
        ImageIcon icon = new ImageIcon(url);
        this.setSprite(icon.getImage());
        this.setHitpoints(100);
        this.setScore(150);

    }

    @Override
    public void move() {
        tick++;
        this.setPosX(this.getPosX() + 20 * (float) Math.cos(tick * 0.05 * Math.PI));
        this.setPosY(this.getPosY() + this.getVelY());
    }

    @Override
    public void update(Level level) {
        move();
        this.weapon.shoot(level);
    }

    @Override
    public Enemy clone() {
        return new Saucer(this.getPosX(), this.getPosY(), this.getVelX(),
                this.getVelY(), this.getWidth(), this.getHeight());
    }

}
