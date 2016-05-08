/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom.specials;

import spaceshooter.dom.GameObject;
import spaceshooter.dom.Level;
import spaceshooter.dom.Shield;

/**
 *
 * @author Aleksi
 */
public class ShieldSpecial extends Special {

    public ShieldSpecial(GameObject parent, double delay) {
        super(parent, delay);

    }

    @Override
    public void spawnSpecial(Level level) {
        float x = this.getParent().getPosX();
        float y = this.getParent().getPosY();
        level.addObject(new Shield(x, y, 0, 0, 64, 64, 60, this.getParent()));
    }

}
