package spaceshooter.dom;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 * Absorbs taken damage for a certain time.
 *
 */
public class Shield extends ImageObject {

    private int ticks;
    private GameObject parent;

    /**
     * Constructor for Shield.
     *
     * @param x x-coordinate.
     * @param y y-coordinate.
     * @param vx x-velocity.
     * @param vy y-velocity.
     * @param w Hitbox widht.
     * @param h Hitbox height.
     * @param ticks Ticks alive.
     * @param parent Parent of this object.
     */
    public Shield(float x, float y, float vx, float vy, int w, int h, int ticks, GameObject parent) {
        super(x, y, vx, vy, w, h);
        this.ticks = ticks;
        URL url = this.getClass().getResource("/Sprites/shield.png");
        ImageIcon icon = new ImageIcon(url);
        this.setSprite(icon.getImage());
        this.parent = parent;
        this.parent.setCollisionOn(false);
    }

    @Override
    public void update(Level level) {
        move();
        tick();
    }

    @Override
    public void onDeath(Level level) {
        this.parent.setCollisionOn(true);
    }

    @Override
    public void move() {
        this.setPosX(this.parent.getPosX() - 16);
        this.setPosY(this.parent.getPosY() - 16);
    }

    /**
     * Reduces ticks by one every frame.
     */
    public void tick() {
        this.ticks--;
        if (this.ticks < 1) {
            this.setIsAlive(false);
        }
    }

    public int getTicks() {
        return ticks;
    }

    public void setTicks(int ticks) {
        this.ticks = ticks;
    }

    public GameObject getParent() {
        return parent;
    }

    public void setParent(GameObject parent) {
        this.parent = parent;
    }

}
