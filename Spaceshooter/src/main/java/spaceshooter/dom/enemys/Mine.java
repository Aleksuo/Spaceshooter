/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom.enemys;

import javax.swing.ImageIcon;
import spaceshooter.dom.Level;
import spaceshooter.dom.Player;

/**
 * Enemy object that follows the player until it is destroyed or it collides
 * with the player.
 *
 */
public class Mine extends Enemy {

    /**
     * Constructor for Mine.
     *
     * @param x x-coordinate.
     * @param y y-coordinate.
     * @param vx x-velocity.
     * @param vy y-velocity.
     * @param w width.
     * @param h height.
     */
    public Mine(float x, float y, float vx, float vy, int w, int h) {
        super(x, y, vx, vy, w, h);
        ImageIcon icon = new ImageIcon("./Resources/Sprites/miina.png");
        this.setSprite(icon.getImage());
        this.setHitpoints(75);
        this.setScore(100);
    }
    
    @Override
    public Enemy clone(){
        return new Mine(0,0,this.getVelX(),this.getVelY(),32,32);
    }

    @Override
    public void update(Level taso) {
        move(taso.getPlayer());
    }

    /**
     * This object moves towards the player.
     *
     * @param p player.
     */
    public void move(Player p) {
        this.setVelX((p.getPosX() - this.getPosX()) / 30);
        this.setVelY((p.getPosY() - this.getPosY()) / 30);

        this.setPosX(this.getPosX() + this.getVelX());
        this.setPosY(this.getPosY() + this.getVelY());
    }

}
