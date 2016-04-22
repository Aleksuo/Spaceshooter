package spaceshooter.commands;

/**
 * Abstract class for commands.
 */
public abstract class Command {

    private double time;

    /**
     * Constructor for Command-class.
     *
     * @param time Excecution time in seconds.
     */
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
