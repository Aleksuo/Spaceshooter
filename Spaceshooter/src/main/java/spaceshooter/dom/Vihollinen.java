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
public class Vihollinen extends KuvallinenObjekti {

    public Vihollinen(int x, int y, int vx, int vy, int w, int h) {
        super(x, y, vx, vy, w, h);
        ImageIcon icon = new ImageIcon("./Resources/Sprites/vihollinen.png");
        this.setSprite(icon.getImage());
        this.setIsAlive(true);
    }
    
    @Override
    public void update(Taso taso){
        liiku(taso.getPelaaja());
    }
    
    @Override
    public void onCollision(Objekti obj){
        if(obj instanceof Ammus){
            this.setIsAlive(false);
        }
    }
    
    public void liiku(Pelaaja p){
        this.setVelX((p.getPosX() - this.getPosX())/30);
        this.setVelY((p.getPosY()- this.getPosY())/30);
        
        this.setPosX(this.getPosX()+ this.getVelX());
        this.setPosY(this.getPosY()+this.getVelY());
    }

}
