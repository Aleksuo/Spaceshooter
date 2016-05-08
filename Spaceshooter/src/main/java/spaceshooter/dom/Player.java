/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import spaceshooter.dom.pickups.Update;
import spaceshooter.dom.weapons.Weapon;
import spaceshooter.dom.weapons.PlayerWeapon;
import spaceshooter.dom.projectiles.EnemyProjectile;
import java.awt.Point;
import java.net.URL;
import javax.swing.ImageIcon;
import spaceshooter.dom.enemys.Enemy;
import spaceshooter.dom.pickups.Charge;
import spaceshooter.dom.specials.ShieldSpecial;
import spaceshooter.dom.specials.Special;

/**
 * Object that can be controlled with user input.
 *
 */
public class Player extends ImageObject {

    private int ships;
    private Weapon weapon;
    private Special special;

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
        URL url = this.getClass().getResource("/Sprites/alus.png");
        ImageIcon icon = new ImageIcon(url);
        this.setSprite(icon.getImage());
        this.ships = 3;
        this.weapon = new PlayerWeapon(this, 5, 25);
        this.special = new ShieldSpecial(this, 5);

    }

    @Override
    public void update(Level taso) {
        Point piste = taso.getMouse();
        if (piste != null) {
            this.setPosX(piste.x);
            this.setPosY(piste.y);
        }

    }

    @Override
    public void onCollision(GameObject obj) {
        if (this.isCollisionOn()) {
            if (obj instanceof Enemy) {
                this.destroyShip();
            } else if (obj instanceof EnemyProjectile) {
                this.destroyShip();
            }
        }

        if (obj instanceof Update) {
            this.weapon.upgrade();
        } else if (obj instanceof Charge) {
            this.special.charge();
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

    public Special getSpecial() {
        return special;
    }

    public void setSpecial(Special special) {
        this.special = special;
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

}
