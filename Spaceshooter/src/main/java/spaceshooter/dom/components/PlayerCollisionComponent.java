/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom.components;

import spaceshooter.dom.components.CollisionComponent;
import spaceshooter.dom.GameObject;
import spaceshooter.dom.Player;
import spaceshooter.dom.Enemy;

/**
 *
 * @author Aleksi
 */
public class PlayerCollisionComponent extends CollisionComponent {

    public PlayerCollisionComponent() {
    }

    @Override
    public void onCollision(Object obj) {
        Player p = (Player) this.getObj();
        if (obj instanceof Enemy) {
            if (p.getShips() >= 1) {
                p.setShips(p.getShips() - 1);
                if (p.getShips() == 0) {
                    p.setIsAlive(false);
                }
            }

        }
    }

}
