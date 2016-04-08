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
public class Ammus extends KuvallinenObjekti {

    public Ammus(float x, float y, float vx, float vy, int w, int h) {
        super(x, y, vx, vy, w, h);
        ImageIcon icon = new ImageIcon("./Resources/Sprites/ammus.png");
        this.setSprite(icon.getImage());
        this.setIsAlive(true);
    }
    
    @Override
    public void update(Taso taso){
        liiku();
        if(this.getPosY() < 0){
            this.setIsAlive(false);
        }
    }

    @Override
    public void onCollision(Objekti obj) {
        if(obj instanceof Vihollinen){
            this.setIsAlive(false);
        }
    }
    
    public void liiku(){
        //float dx = this.getPosX() + this.getVelX();
        float dy = this.getPosY() - this.getVelY();
       
        this.setPosY(dy);
    }
    
    
}
