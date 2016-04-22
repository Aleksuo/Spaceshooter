package spaceshooter.util;

/**
 * Class provides a tool for keeping track of elapsed time using
 * System.nanoTime().
 *
 */
public class Timer {

    private long startTime;

    public Timer() {
        this.startTime = System.nanoTime();
    }

    /**
     * Calculates time difference between current time and the start time of
     * this timer.
     *
     * @return Elapsed time in seconds
     */
    public double elapsedTimeInSeconds() {
        long elapsedTime = System.nanoTime() - this.startTime;
        double seconds = (double) elapsedTime / 1000000000.0;
        return seconds;
    }

    /**
     * Sets the start time to current time.
     */
    public void reset() {
        this.startTime = System.nanoTime();
    }
}
