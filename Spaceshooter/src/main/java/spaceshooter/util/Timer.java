/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.util;

/**
 *
 * @author Aleksi
 */
public class Timer {
    private long startTime;
    
    public Timer(){
        this.startTime = System.nanoTime();
    }
    
    public double elapsedTimeInSeconds(){
        long elapsedTime = System.nanoTime() - this.startTime;
        double seconds = (double)elapsedTime/ 1000000000.0;
        return seconds;
    }
    
    public void reset(){
        this.startTime = System.nanoTime();
    }
}
