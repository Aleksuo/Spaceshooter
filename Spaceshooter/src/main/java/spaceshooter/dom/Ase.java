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
public class Ase {
    private Objekti isanta;
    public Ase(Objekti obj){
        this.isanta = obj;
    }
    
    public void ammu(Taso taso){
        float x = this.isanta.getPosX()+16;
        float y = this.isanta.getPosY();
        taso.lisaaObjekti(new Ammus(x,y,10,10,10,10));
    }
}
