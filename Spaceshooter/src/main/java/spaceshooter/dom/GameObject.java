package spaceshooter.dom;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Abstract class for all objects in game.
 *
 */
abstract public class GameObject {

    private float posX;
    private float posY;

    private float velX;
    private float velY;

    private int width;
    private int height;

    private boolean isAlive;
    private boolean collisionOn;

    /**
     * Constructor for GameObject.
     *
     * @param x x-coordinate.
     * @param y y-coordinate.
     * @param vx x-velocity.
     * @param vy y-velocity.
     * @param w width.
     * @param h height.
     */
    public GameObject(float x, float y, float vx, float vy, int w, int h) {
        this.posX = x;
        this.posY = y;

        this.velX = vx;
        this.velY = vy;

        this.width = w;
        this.height = h;

        this.isAlive = true;
        this.collisionOn = true;
    }

    /**
     * Draw method used for drawing objects drawable content.
     *
     * @param g java graphics object
     */
    public void draw(Graphics g) {
    }

    /**
     * Updates object every frame.
     *
     * @param taso Objects' current level
     */
    public void update(Level taso) {
    }

    /**
     * Used for defining how objects react with each other on collisions.
     *
     * @param obj GameObject this object has collided with
     */
    public void onCollision(GameObject obj) {
    }

    /**
     * Defines objects movement.
     */
    public void move() {
    }

    /**
     * Defines objects behavior when it gets removed from level.
     *
     * @param level Objects'
     */
    public void onDeath(Level level) {
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public float getVelX() {
        return velX;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

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

    public boolean isAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isCollisionOn() {
        return collisionOn;
    }

    public void setCollisionOn(boolean collisionOn) {
        this.collisionOn = collisionOn;
    }

    public Rectangle getHitbox() {
        return new Rectangle((int) this.posX, (int) this.posY, this.getWidth(), this.getHeight());
    }

}
