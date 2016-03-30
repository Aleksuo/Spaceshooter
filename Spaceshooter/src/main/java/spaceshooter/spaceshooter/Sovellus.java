/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.spaceshooter;

import javax.swing.JFrame;
import spaceshooter.dom.Taso;

/**
 *
 * @author Aleksi
 */
public class Sovellus extends JFrame {
    public Sovellus(){
        this.InitUI();
    }
    
    public void InitUI(){
        this.add(new Taso());
        this.setSize(500, 500);
        this.setTitle("Shmup");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    
}
