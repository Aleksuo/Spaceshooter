package spaceshooter.logic;

/**
 * Counter used for keeping count of the levelscore.
 *
 */
public class Scorecounter {

    private int score;

    /**
     * Constructor for ScoreCounter.
     */
    public Scorecounter() {
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Increases the score of this counter.
     *
     * @param pisteet Points added.
     */
    public void add(int pisteet) {
        if (pisteet > 0) {
            this.score += pisteet;
        }
    }

    /**
     * Reduces the score of this counter.
     *
     * @param pisteet Points reduced.
     */
    public void reduce(int pisteet) {
        if (pisteet > 0) {
            this.score -= pisteet;
            if (this.score < 0) {
                this.score = 0;
            }
        }
    }

    /**
     * Sets the score of this counter to 0.
     */
    public void reset() {
        this.score = 0;
    }
}
