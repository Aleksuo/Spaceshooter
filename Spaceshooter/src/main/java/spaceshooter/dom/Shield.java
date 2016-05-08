/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Aleksi
 */
public class Shield extends ImageObject {

    private int ticks;
    private GameObject parent;

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

    public void move() {
        this.setPosX(this.parent.getPosX() - 16);
        this.setPosY(this.parent.getPosY() - 16);
    }

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
