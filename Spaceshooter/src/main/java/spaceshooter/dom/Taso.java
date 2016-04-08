/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;
import spaceshooter.util.Collision;

/**
 *
 * @author Aleksi
 */
public class Taso extends JPanel {

    private Pelaaja pelaaja;
    private ArrayList<Objekti> objektit;

    public Taso() {
        this.setBackground(Color.black);
        this.pelaaja = new Pelaaja(0, 0, 32, 32);
        this.objektit = new ArrayList<Objekti>();
        this.objektit.add(new Vihollinen(0, 10, 10, 0, 0, 0));
        this.objektit.add(new Vihollinen(100, 0, 20, 20, 0, 0));

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
        repaint();
    }

    public void draw(Graphics g) {

        pelaaja.draw(g);
        for (Objekti o : objektit) {
            if (o instanceof KuvallinenObjekti) {
                KuvallinenObjekti kuvallinen = (KuvallinenObjekti) o;
                kuvallinen.draw(g);
            }
        }

    }

    public void update() {
        pelaaja.update(this);
        for (Objekti o : objektit) {
            o.update(this);
        }
        //tarkistetaaan törmäykset
        for (Objekti o : objektit) {
            if (o.isAlive()) {
                if (Collision.isCollision(pelaaja.getHitbox(), o.getHitbox())) {
                    pelaaja.onCollision(o);
                }

            }

        }
        //poistetaan kuolleet objektit
        for(int i = 0; i<this.objektit.size()-1; i++){
            if(!this.objektit.get(i).isAlive()){
                poistaObjekti(i);
            }
        }
    }

    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    public void setPelaaja(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }

    public void lisaaObjekti(Objekti obj) {
        this.objektit.add(obj);
    }

    public void poistaObjekti(int i) {
        this.objektit.remove(i);
    }

}
