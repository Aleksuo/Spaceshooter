/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom.enemys;

import javax.swing.ImageIcon;
import spaceshooter.dom.enemys.Enemy;
import spaceshooter.dom.EnemyWeapon;
import spaceshooter.dom.GameObject;
import spaceshooter.dom.Level;
import spaceshooter.dom.Weapon;

/**
 *
 * @author Aleksi
 */
public class Saucer extends Enemy {
    private int tick = 0;
   
    
    private Weapon weapon;

    public Saucer(float x, float y, float vx, float vy, int w, int h) {
        super(x, y, vx, vy, w, h);
        this.weapon = new EnemyWeapon(this,5,25);
        ImageIcon icon = new ImageIcon("./Resources/Sprites/vihollinen.png");
        this.setSprite(icon.getImage());
        this.setHitpoints(100);
        this.setScore(150);
       
    }
    
    @Override
    public void move(){
        tick++;
        this.setPosX(this.getPosX() + 20 * (float) Math.cos(tick * 0.05 * Math.PI));
        this.setPosY(this.getPosY() + this.getVelY());
    }
    
    @Override
    public void update(Level level){
        move();
        this.weapon.shoot(level);
    }

    @Override
    public Enemy clone() {
        return new Saucer(this.getPosX(), this.getPosY(), this.getVelX(),
                this.getVelY(), this.getWidth(), this.getHeight());
    }
    
    
    
}
