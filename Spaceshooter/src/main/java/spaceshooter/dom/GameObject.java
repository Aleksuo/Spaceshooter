/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import java.awt.Rectangle;

/**
 *
 * @author Aleksi
 */
public class GameObject {

    private float posX;
    private float posY;

    private float velX;
    private float velY;

    private int width;
    private int height;

    private boolean isAlive;

    public GameObject(float x, float y, float vx, float vy, int w, int h) {
        this.posX = x;
        this.posY = y;

        this.velX = vx;
        this.velY = vy;

        this.width = w;
        this.height = h;
    }

    public void update(Level taso) {
    }

    public void onCollision(GameObject obj) {
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

    public Rectangle getHitbox() {
        return new Rectangle((int) this.posX, (int) this.posY, this.getWidth(), this.getHeight());
    }

}