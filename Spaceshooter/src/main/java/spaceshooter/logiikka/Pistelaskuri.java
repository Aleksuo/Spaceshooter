/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.logiikka;

/**
 *
 * @author Aleksi
 */
public class Pistelaskuri {

    private int pisteet;

    public Pistelaskuri() {
        this.pisteet = 0;
    }

    public int getPisteet() {
        return pisteet;
    }

    public void setPisteet(int pisteet) {
        this.pisteet = pisteet;
    }

    public void lisaa(int pisteet) {
        if (pisteet > 0) {
            this.pisteet += pisteet;
        }
    }

    public void vahenna(int pisteet) {
        if (pisteet > 0) {
            this.pisteet -= pisteet;
            if (this.pisteet < 0) {
                this.pisteet = 0;
            }
        }
    }
    
    public void nollaa(){
        this.pisteet = 0;
    }
}
