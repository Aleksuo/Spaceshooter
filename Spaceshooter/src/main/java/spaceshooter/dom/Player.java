/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import java.awt.Point;
import javax.swing.ImageIcon;
import spaceshooter.dom.enemys.Enemy;

/**
 * Object that can be controlled with user input.
 *
 */
public class Player extends ImageObject {

    private int ships;
    private int charges;
    private Weapon weapon;

    /**
     * Constructor for Player.
     *
     * @param x x-coordinate.
     * @param y y-coordinate.
     * @param w width.
     * @param h height.
     */
    public Player(int x, int y, int w, int h) {
        super(x, y, 0, 0, w, h);
        ImageIcon icon = new ImageIcon("./Resources/Sprites/alus.png");
        this.setSprite(icon.getImage());
        this.ships = 3;
        this.charges = 3;
        this.weapon = new PlayerWeapon(this, 5, 25);
    }

    @Override
    public void update(Level taso) {
        Point piste = taso.getMousePosition();
        if (piste != null) {
            this.setPosX(piste.x);
            this.setPosY(piste.y);
        }

    }

    @Override
    public void onCollision(GameObject obj) {
        if (obj instanceof Enemy) {
            this.destroyShip();
        } else if (obj instanceof Update) {
            this.weapon.upgrade();
        } else if (obj instanceof EnemyProjectile) {
            this.destroyShip();
        }

    }

    /**
     * Decreases players ship count.
     */
    private void destroyShip() {

        this.ships--;
        if (this.ships < 1) {
            this.setIsAlive(false);
        }
    }

    public int getShips() {
        return ships;
    }

    public void setShips(int ships) {
        this.ships = ships;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getCharges() {
        return charges;
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }

}
