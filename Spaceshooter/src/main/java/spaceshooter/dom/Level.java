package spaceshooter.dom;

import spaceshooter.dom.enemys.Saucer;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

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
public class Level {

    private Player player;
    private ConcurrentLinkedQueue<GameObject> objektit;

    private Scorecounter score;
    private Image background;

    private int width;
    private int height;

    private Point mouse;

    /**
     * Levels constructor.
     */
    public Level() {
        this.width = 800;
        this.height = 640;
        this.score = new Scorecounter();

        URL url = this.getClass().getResource("/Sprites/background.png");
        ImageIcon icon = new ImageIcon(url);
        this.background = icon.getImage();

        this.player = new Player(0, 0, 32, 32);
        this.objektit = new ConcurrentLinkedQueue<GameObject>();

        this.objektit.add(player);

    }

    /**
     * Draws every object in level.
     *
     * @param g java graphics object.
     */
    public void draw(Graphics g) {
        g.drawImage(background, 0, 0, null);

        for (GameObject o : objektit) {

            o.draw(g);
        }

        g.setColor(Color.WHITE);
        g.drawString("Score: " + Integer.toString(this.score.getScore()), 32, 32);
        g.drawString("Ships: " + Integer.toString(this.player.getShips()), 600, 32);
        g.drawString("Charges: " + Integer.toString(this.player.getCharges()), 700, 32);

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
            keepPlayerInsideLevel();
            if (checkIfOutsideScreen(o) && !(o instanceof Player)) {
                o.setIsAlive(false);
            }
        }

    }

    private void keepPlayerInsideLevel() {
        if (this.player.getPosX() < 0) {
            this.player.setPosX(0);
        } else if (this.player.getPosY() < 0) {
            this.player.setPosX(0);
        } else if (this.player.getPosY() > this.width) {
            this.player.setPosX(this.width - this.player.getWidth());
        } else if (this.player.getPosY() > this.getHeight()) {
            this.player.setPosY(this.height - this.player.getHeight());
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

    public Image getBackground() {
        return background;
    }

    public void setBackground(Image background) {
        this.background = background;
    }

    //todo tee omaan luokkaan listenerit
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Point getMouse() {
        return mouse;
    }

    public void setMouse(Point mouse) {
        this.mouse = mouse;
    }

}
