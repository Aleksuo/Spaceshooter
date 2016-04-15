package spaceshooter.commands;

import spaceshooter.commands.Command;

/**
 * Command that holds information about spawning an enemy object. Format in
 * textfile: float time, SPAWN_ENEMY, int enemyId, float x, float y
 */
public class SpawnEnemyCommand extends Command {

    private int enemyId;
    private float x;
    private float y;

    public SpawnEnemyCommand(double time, int id, float x, float y) {
        super(time);
        this.enemyId = id;
        this.x = x;
        this.y = y;
    }

    public int getEnemyId() {
        return enemyId;
    }

    public void setEnemyId(int enemyId) {
        this.enemyId = enemyId;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

}
