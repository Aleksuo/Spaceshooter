/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom.Components.Collision;


import spaceshooter.dom.Objekti;
import spaceshooter.dom.Pelaaja;
import spaceshooter.dom.Vihollinen;

/**
 *
 * @author Aleksi
 */
public class PlayerCollisionComponent extends CollisionComponent{

    public PlayerCollisionComponent() {
    }
    
    @Override
    public void onCollision(Object obj){
        Pelaaja p = (Pelaaja)this.getObj();
        if (obj instanceof Vihollinen) {
            if (p.getAlukset() >= 1) {
                p.setAlukset(p.getAlukset()-1);
                if (p.getAlukset() == 0) {
                    p.setIsAlive(false);
                }
            }

        }
    }
    
}
