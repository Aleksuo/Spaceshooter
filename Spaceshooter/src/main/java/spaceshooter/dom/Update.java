/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import javax.swing.ImageIcon;
import java.lang.*;
/**
 * Update -pickup that updates players weapon on collision.
 *
 */
public class Update extends ImageObject  {
    private int tick = 0;
    private float beginX;
    private float beginY;
 

    public Update(float x, float y, float vx, float vy, int w, int h) {
        super(x, y, vx, vy, w, h);
        ImageIcon icon = new ImageIcon("./Resources/Sprites/update.png");
        this.setSprite(icon.getImage());
        this.beginX=x;
        this.beginY=y;
    }
    
    @Override
    public void update(Level taso){
        move();
    }
    
    public void move(){
        tick++;
        this.setPosX( 250 + 100 *(float)Math.cos(tick*0.05*Math.PI));
        this.setPosY(this.getPosY()+this.getVelY());
    }
    
    @Override
    public void onCollision(GameObject obj){
        if(obj instanceof Player){
            this.setIsAlive(false);
        }
    }

}
