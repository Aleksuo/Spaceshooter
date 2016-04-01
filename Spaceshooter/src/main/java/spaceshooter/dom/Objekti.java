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
public class Objekti {
    private int posX;
    private int posY;
    
    private int velX;
    private int velY;
    
    private int width;
    private int height;
    
    public Objekti(int x, int y, int vx, int vy, int w, int h){
        this.posX = x;
        this.posY = y;
        
        this.velX = vx;
        this.velY = vy;
        
        this.width = w;
        this.height = h;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
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
    
    public Rectangle getHitbox(){
        return new Rectangle(this.posX,this.posX,this.getWidth(),this.getHeight());
    }
    
}
