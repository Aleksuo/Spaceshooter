/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import java.awt.Point;
import javax.swing.ImageIcon;

/**
 *
 * @author Aleksi
 */
public class Player extends ImageObject {

    private int ships;
    private Weapon weapon;

    public Player(int x, int y, int w, int h) {
        super(x, y, 0, 0, w, h);
        ImageIcon icon = new ImageIcon("./Resources/Sprites/alus.png");
        this.setSprite(icon.getImage());
        this.ships = 3;
        this.weapon = new Weapon(this);
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
            if (this.ships >= 1) {
                this.ships--;
                if (this.ships < 1) {
                    this.setIsAlive(false);
                }
            }
            this.setPosX(0);
            this.setPosY(0);

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

}
