/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.spaceshooter;

import java.awt.Point;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import spaceshooter.dom.Taso;

/**
 *
 * @author Aleksi
 */
public class Sovellus extends JFrame{

    private Taso taso;
    private boolean pelissa;

    public Sovellus() {
        this.initUI();
        pelissa = true;
    }

    public void initUI() {
        taso = new Taso();
        this.add(taso);
        this.pack();
        this.setSize(500, 500);
        this.setTitle("Shmup");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        taso.requestFocus();
        

        this.setCursor(this.getToolkit().createCustomCursor(
                new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),
                "null"));

    }

    public void loop() {
        double next_game_tick = System.currentTimeMillis();
        int loops;

        while (pelissa) {
            loops = 0;
            while (System.currentTimeMillis() > next_game_tick
                    && loops < 5) {

                taso.update();

                next_game_tick += 1000 / 15;
                loops++;

            }

        }

    }

    

}
