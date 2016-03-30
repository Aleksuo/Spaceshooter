/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

/**
 *
 * @author Aleksi
 */
public class Taso extends JPanel{
    private Pelaaja pelaaja;
    
    public Taso(){
        this.pelaaja = new Pelaaja(0,0,0,0,0,0);
    }
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        pelaaja.draw(g2d);
        
    }
    
    
}
