/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.swing.JPanel;

import spaceshooter.util.Collision;

/**
 *
 * @author Aleksi
 */
public class Taso extends JPanel implements KeyListener {

    private Pelaaja pelaaja;
    private ConcurrentLinkedQueue<Objekti> objektit;

    public Taso() {
        this.setDoubleBuffered(true);
        this.setBackground(Color.black);
        this.pelaaja = new Pelaaja(0, 0, 32, 32);
        this.objektit = new ConcurrentLinkedQueue<Objekti>();
        this.addKeyListener(this);
        this.objektit.add(pelaaja);
        this.objektit.add(new Vihollinen(0, 10, 10, 0, 32, 32));
        this.objektit.add(new Vihollinen(100, 0, 20, 20, 32, 32));

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
        repaint();
    }

    public void draw(Graphics g) {

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
                for (Objekti t : objektit) {
                    if (t.isAlive()) {
                        if (Collision.isCollision(t.getHitbox(), o.getHitbox())) {
                            o.onCollision(t);
                            t.onCollision(o);

                        }

                    }
                }

            }

        }
        //poistetaan kuolleet objektit
        for (Iterator<Objekti> iterator = objektit.iterator(); iterator.hasNext();) {
            Objekti obj = iterator.next();
            if (!obj.isAlive()) {
                iterator.remove();
            }
        }
        System.out.println("Objekteja: " + objektit.size());
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.pelaaja.getAse().ammu(this);
            System.out.println("väli painettu");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
