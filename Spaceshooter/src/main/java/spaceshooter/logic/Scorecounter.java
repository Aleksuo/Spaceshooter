package spaceshooter.logic;

/**
 * Counter used for keeping count of the levelscore.
 *
 */
public class Scorecounter {

    private int score;

    public Scorecounter() {
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void add(int pisteet) {
        if (pisteet > 0) {
            this.score += pisteet;
        }
    }

    public void reduce(int pisteet) {
        if (pisteet > 0) {
            this.score -= pisteet;
            if (this.score < 0) {
                this.score = 0;
            }
        }
    }

    public void reset() {
        this.score = 0;
    }
}
