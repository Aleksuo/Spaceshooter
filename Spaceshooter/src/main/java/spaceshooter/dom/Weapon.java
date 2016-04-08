/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

/**
 *
 * @author Aleksi
 */
public class Weapon {
    private GameObject parent;
    public Weapon(GameObject obj){
        this.parent = obj;
    }
    
    public void ammu(Level taso){
        float x = this.parent.getPosX()+16;
        float y = this.parent.getPosY();
        taso.addObject(new Projectile(x,y,10,10,10,10));
    }
}
