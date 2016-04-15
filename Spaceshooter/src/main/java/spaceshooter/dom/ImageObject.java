/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * Abstract class for all objects that have a sprite.
 *
 */
abstract public class ImageObject extends GameObject {

    private Image sprite;

    public ImageObject(float x, float y, float vx, float vy, int w, int h) {
        super(x, y, vx, vy, w, h);
    }

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.getSprite(), (int) this.getPosX(), (int) this.getPosY(), null);
    }

}
