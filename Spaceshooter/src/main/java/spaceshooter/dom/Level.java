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
 * Class that holds data for a level.
 *
 */
public class Level extends JPanel implements KeyListener {

    private Player player;
    private ConcurrentLinkedQueue<GameObject> objektit;

    public Level() {
        this.setDoubleBuffered(true);
        this.setBackground(Color.black);
        this.player = new Player(0, 0, 32, 32);
        this.objektit = new ConcurrentLinkedQueue<GameObject>();
        this.addKeyListener(this);
        this.objektit.add(player);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
        repaint();
    }

    public void draw(Graphics g) {

        for (GameObject o : objektit) {

            o.draw(g);
        }

    }

    public void tick() {
        update();
        checkCollisions();
        removeDeadObjects();
        //System.out.println("Objekteja: " + objektit.size());
    }

    public void update() {
        for (GameObject o : objektit) {
            o.update(this);
        }
    }

    //todo eriytä omaan luokkaan
    public void checkCollisions() {
        for (GameObject o : objektit) {
            if (o.isAlive()) {
                for (GameObject t : objektit) {
                    if (t.isAlive()) {
                        if (Collision.isCollision(t.getHitbox(), o.getHitbox())) {
                            o.onCollision(t);
                            t.onCollision(o);

                        }

                    }
                }

            }

        }
    }

    public void removeDeadObjects() {
        for (Iterator<GameObject> iterator = objektit.iterator(); iterator.hasNext();) {
            GameObject obj = iterator.next();
            if (!obj.isAlive()) {
                iterator.remove();
            }
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void addObject(GameObject obj) {
        this.objektit.add(obj);
    }

    //todo tee omaan luokkaan listenerit
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.player.getWeapon().shoot(this);
            System.out.println("väli painettu");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
