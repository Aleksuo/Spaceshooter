/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Aleksi
 */
public class Pelaaja extends Objekti {
    private Image sprite;

    public Pelaaja(int x, int y, int vx, int vy, int w, int h) {
        super(x, y, vx, vy, w, h);
        ImageIcon icon = new ImageIcon("Resources/Sprites/alus.bmp");
        if(icon == null){
            System.out.println("Virhe");
        }
        this.sprite = icon.getImage();
    }
    
    public void draw(Graphics2D g){
        g.drawImage(sprite, null, null);
    }
            
    
}
