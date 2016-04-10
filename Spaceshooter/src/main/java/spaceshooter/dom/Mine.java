/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import javax.swing.ImageIcon;

/**
 *
 * @author Aleksi
 */
public class Mine extends Enemy{

    public Mine(float x, float y, int vx, int vy, int w, int h) {
        super(x, y, vx, vy, w, h);
        ImageIcon icon = new ImageIcon("./Resources/Sprites/miina.png");
        this.setSprite(icon.getImage());
        this.setHitpoints(75);
        this.setIsAlive(true);
    }
    
    @Override
    public void update(Level taso) {
        move(taso.getPlayer());
    }
    
    public void move(Player p) {
        this.setVelX((p.getPosX() - this.getPosX()) / 30);
        this.setVelY((p.getPosY() - this.getPosY()) / 30);

        this.setPosX(this.getPosX() + this.getVelX());
        this.setPosY(this.getPosY() + this.getVelY());
    }
    
    @Override
    public void onCollision(GameObject obj) {
        if (obj instanceof Projectile) {
            Projectile projectile = (Projectile)obj;
            int newHp = this.getHitpoints()- projectile.getDamage();
            this.setHitpoints(newHp);
            if(this.getHitpoints()< 0){
                this.setIsAlive(false);
            }
        }
    }
    
}
