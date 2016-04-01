/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;

/**
 *
 * @author Aleksi
 */
public class Pelaaja extends Objekti {
    
    private int alukset;
    
    private Image sprite;

    public Pelaaja(int x, int y,int w, int h) {
        super(x, y, 0, 0, w, h);
        ImageIcon icon = new ImageIcon("./Resources/Sprites/alus.png");
        this.sprite = icon.getImage();
        this.alukset = 3;
    }
    
    public void draw(Graphics g){
        g.drawImage(this.sprite, this.getPosX(), this.getPosY(), null);
    }
    
    public void update(Taso taso){
        Point piste = taso.getMousePosition();
        if(piste != null){
            this.setPosX(piste.x);
            this.setPosY(piste.y);
        }
        
        
    }
            
    
}
