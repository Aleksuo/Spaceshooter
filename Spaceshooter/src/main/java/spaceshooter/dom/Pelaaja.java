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
public class Pelaaja extends KuvallinenObjekti{

    private int alukset;

    public Pelaaja(int x, int y, int w, int h) {
        super(x, y, 0, 0, w, h);
        ImageIcon icon = new ImageIcon("./Resources/Sprites/alus.png");
        this.setSprite(icon.getImage());
        this.alukset = 3;

        this.setIsAlive(true);
    }

    @Override
    public void update(Taso taso) {
        Point piste = taso.getMousePosition();
        if (piste != null) {
            this.setPosX(piste.x);
            this.setPosY(piste.y);
        }

    }

    public int getAlukset() {
        return alukset;
    }

    public void setAlukset(int alukset) {
        this.alukset = alukset;
    }

    @Override
    public void onCollision(Objekti obj) {
        if (obj instanceof Vihollinen) {
            if (this.alukset >= 1) {
                this.alukset--;
                if (this.alukset == 0) {
                    this.setIsAlive(false);
                }
            }
            this.setPosX(0);
            this.setPosY(0);

        }
    }

}
