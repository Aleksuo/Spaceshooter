/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Aleksi
 */
public class Taso extends JPanel {

    private Pelaaja pelaaja;

    public Taso() {
        this.setBackground(Color.black);
        this.pelaaja = new Pelaaja(0, 0, 0, 0);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
        repaint();
    }

    public void draw(Graphics g) {

        pelaaja.draw(g);

    }

    public void update() {
        pelaaja.update(this);
    }

}
