package spaceshooter.dom;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.swing.JPanel;
import spaceshooter.logic.Scorecounter;

import spaceshooter.util.Collision;

/**
 * Class that holds data for a level.
 *
 */
public class Level extends JPanel implements KeyListener {

    private Player player;
    private ConcurrentLinkedQueue<GameObject> objektit;

    private Scorecounter score;

    public Level() {
        this.score = new Scorecounter();
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
        g.setColor(Color.WHITE);
        g.drawString("Score: " + Integer.toString(this.score.getScore()), 32, 32);
        g.drawString("Ships: " + Integer.toString(this.player.getShips()), this.getWidth() - 200, 32);
        g.drawString("Charges: " + Integer.toString(this.player.getCharges()), this.getWidth() - 100, 32);

    }

    /**
     * Calls private methods update(), checkCollisions() and removeDeadObjects()
     * every frame.
     */
    public void tick() {
        update();
        checkCollisions();
        removeDeadObjects();
    }

    private void update() {
        for (GameObject o : objektit) {
            o.update(this);
        }
    }

    //todo eriytä omaan luokkaan
    private void checkCollisions() {
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

    private void removeDeadObjects() {
        for (Iterator<GameObject> iterator = objektit.iterator(); iterator.hasNext();) {
            GameObject obj = iterator.next();
            if (!obj.isAlive()) {
                obj.onDeath(this);
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

    public ConcurrentLinkedQueue<GameObject> getObjektit() {
        return objektit;
    }

    public void setObjektit(ConcurrentLinkedQueue<GameObject> objektit) {
        this.objektit = objektit;
    }

    public Scorecounter getScore() {
        return score;
    }

    public void setScore(Scorecounter score) {
        this.score = score;
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

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
