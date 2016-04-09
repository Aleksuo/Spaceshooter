/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import javax.swing.ImageIcon;

/**
 *
 * @author Aleksi
 */
public class Projectile extends ImageObject {

    public Projectile(float x, float y, float vx, float vy, int w, int h) {
        super(x, y, vx, vy, w, h);
        ImageIcon icon = new ImageIcon("./Resources/Sprites/ammus.png");
        this.setSprite(icon.getImage());
    }

    @Override
    public void update(Level taso) {
        move();
        if (this.getPosY() < 0) {
            this.setIsAlive(false);
        }
    }

    @Override
    public void onCollision(GameObject obj) {
        if (obj instanceof Enemy) {
            this.setIsAlive(false);
        }
    }

    public void move() {
        //float dx = this.getPosX() + this.getVelX();
        float dy = this.getPosY() - this.getVelY();

        this.setPosY(dy);
    }

}
