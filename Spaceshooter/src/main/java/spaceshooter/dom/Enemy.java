package spaceshooter.dom;

import javax.swing.ImageIcon;
import java.util.Random;

/**
 * Abstract class for Enemy objects.
 *
 */
abstract public class Enemy extends ImageObject {

    private int hitpoints;
    private int score;

    /**
     * Constructor for Enemy object.
     *
     * @param x x-coordinate.
     * @param y y-coordinate.
     * @param vx x-velocity.
     * @param vy y-velocity.
     * @param w width.
     * @param h height.
     */
    public Enemy(float x, float y, float vx, float vy, int w, int h) {
        super(x, y, vx, vy, w, h);

    }

    @Override
    public void onDeath(Level level) {
        level.getScore().add(score);
        if (new Random().nextInt(10) == 1) {
            level.addObject(new Update(this.getPosX(), this.getPosY(), 10, 10, 32, 32));
        }

    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
