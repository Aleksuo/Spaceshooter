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
public class Sovellus extends JFrame {

    private Taso taso;
    private boolean pelissa;

    public Sovellus() {
        this.InitUI();
        pelissa = true;
    }

    public void InitUI() {
        taso = new Taso();
        this.add(taso);
        this.setSize(500, 500);
        this.setTitle("Shmup");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setCursor(this.getToolkit().createCustomCursor(
                new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),
                "null"));

    }

    public void loop() {
        while (pelissa) {
            taso.update();

        }
    }

}
