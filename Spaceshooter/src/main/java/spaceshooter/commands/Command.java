/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.commands;

/**
 *
 * @author Aleksi
 */
public abstract class Command{
    private double time;
    
    public Command(double time){
        this.time = time;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
    
    
    
}
