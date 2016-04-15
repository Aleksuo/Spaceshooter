/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

/**
 * Update -pickup that updates players weapon on collision.
 *
 */
public class Update extends ImageObject implements IPickUp {

    public Update(int x, int y, int vx, int vy, int w, int h) {
        super(x, y, vx, vy, w, h);
    }

}
