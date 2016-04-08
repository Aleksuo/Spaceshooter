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
    }
    
    @Override
    public void update(Taso taso){
        liiku(taso.getPelaaja());
    }
    
    @Override
    public void onCollision(Objekti obj){
        
    }
    
    public void liiku(Pelaaja p){
        this.setVelX((p.getPosX() - this.getPosX()));
        this.setVelY((p.getPosY()- this.getPosY()));
        
        this.setPosX(this.getPosX()+ this.getVelX());
        this.setPosY(this.getPosY()+this.getVelY());
    }

}
