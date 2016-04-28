package spaceshooter.dom;

import spaceshooter.dom.enemys.Saucer;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.swing.ImageIcon;

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
    private Image background;

    /**
     * Levels constructor.
     */
    public Level() {
        this.score = new Scorecounter();
        this.setDoubleBuffered(true);
        this.setBackground(Color.black);
        ImageIcon icon = new ImageIcon("./Resources/Sprites/background.png");
        this.background = icon.getImage();
        

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

    /**
     * Draws every object in level.
     *
     * @param g java graphics object.
     */
    public void draw(Graphics g) {
        g.drawImage(background, 0, 0, this);

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

    /**
     * Calls update for every GameObject in level.
     */
    private void update() {
        for (GameObject o : objektit) {
            o.update(this);
            if(checkIfOutsideScreen(o)){
                o.setIsAlive(false);
            }
        }
    }

    private boolean checkIfOutsideScreen(GameObject obj) {
        if (obj.getPosX() < 0 || obj.getPosX() > this.getWidth()) {
            return true;
        }

        if (obj.getPosY() < 0 || obj.getPosY() > this.getHeight()) {
            return true;
        }
        
        return false;

    }

    /**
     * Checks collisions between GameObjects.
     */
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

    /**
     * Removes dead GameObjects and calls objects onDeath() method.
     */
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

    /**
     * Adds a GameObject to level.
     *
     * @param obj GameObject to be added.
     */
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
