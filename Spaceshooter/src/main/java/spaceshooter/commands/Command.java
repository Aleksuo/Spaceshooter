package spaceshooter.commands;

/**
 * Abstract class for commands
 *
 */
public abstract class Command {

    private double time;

    public Command(double time) {
        this.time = time;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

}
