/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.gui;

import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Aleksi
 */
public class Window {

    private JFrame frame;
    private Canvas canvas;

    private int width;
    private int height;

    public Window(int width, int height) {
        Dimension dim = new Dimension(width, height);
        this.width = width;
        this.height = height;
        initCanvas(dim);
        initWindow(dim);

    }

    private void initWindow(Dimension dim) {
        this.frame = new JFrame("Shmup");
        this.frame.setSize(dim);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        this.frame.add(this.canvas);
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                cursorImg, new Point(0, 0), "blank cursor");
        this.frame.getContentPane().setCursor(blankCursor);

        frame.pack();
    }

    private void initCanvas(Dimension dim) {
        this.canvas = new Canvas();
        this.canvas.setPreferredSize(dim);
        this.canvas.setMaximumSize(dim);
        this.canvas.setMinimumSize(dim);
        this.canvas.setFocusable(false);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
