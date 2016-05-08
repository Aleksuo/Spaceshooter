/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.gui;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 *
 * @author Aleksi
 */
public class MenuGUI extends JPanel {

    public MenuGUI(int width, int height) {

        this.setSize(width, height);
        JButton b1 = new JButton("Start Game");
        JButton b2 = new JButton("Exit Game");

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(b1);
        this.add(b2);

    }
}
