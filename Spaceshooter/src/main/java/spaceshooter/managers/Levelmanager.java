package spaceshooter.managers;

import com.sun.glass.events.KeyEvent;
import java.awt.Graphics;
import java.awt.Point;
import java.util.PriorityQueue;

import spaceshooter.commands.Command;
import spaceshooter.commands.SpawnEnemyCommand;
import spaceshooter.dom.GameObject;
import spaceshooter.dom.Level;
import spaceshooter.dom.enemys.Enemy;

import spaceshooter.input.KeyManager;
import spaceshooter.util.LevelLoader;
import spaceshooter.util.Timer;

/**
 * Manager used to manage level related things.
 *
 */
public class Levelmanager {

    private Level level;
    private LevelLoader levelLoader;
    private Timer timer;

    private SpawnManager spawnManager;

    private PriorityQueue<Command> commands;

    /**
     * Constructor for LevelManager.
     */
    public Levelmanager() {
        this.level = new Level();
        this.levelLoader = new LevelLoader();
        this.spawnManager = new SpawnManager(this.level);
        this.loadLevelCommandData();

        this.timer = new Timer();
    }

    /**
     * Renders the level.
     *
     * @param g Graphics object.
     */
    public void render(Graphics g) {
        this.level.draw(g);
    }

    /**
     * Handles input.
     *
     * @param km Apps KeyManager.
     * @param point Mouses current position.
     */
    public void handleInput(KeyManager km, Point point) {
        if (km.isPressed(KeyEvent.VK_W)) {
            this.level.getPlayer().getWeapon().shoot(level);
        }
        if (km.isPressed(KeyEvent.VK_SPACE)) {
            this.level.getPlayer().getSpecial().trigger(level);
        }
        this.level.setMouse(point);
    }

    /**
     * Does things that should done every frame Calls levels tick method and
     * handleCommands() -method.
     */
    public void tick() {
        this.level.tick();
        this.handleCommands();

    }

    /**
     * Loads Commands used for events on level.
     */
    public void loadLevelCommandData() {
        this.commands = levelLoader.loadLevelFromFile("level1.txt");
    }

    /**
     * Checks if there are any commands that need to be executed. Called every
     * frame.
     */
    public void handleCommands() {

        while ((!this.commands.isEmpty())
                && (this.timer.elapsedTimeInSeconds() >= this.commands.peek().getTime())) {
            Command command = this.commands.poll();
            if (command instanceof SpawnEnemyCommand) {
                SpawnEnemyCommand spec = (SpawnEnemyCommand) command;
                this.spawnManager.handleSpawnCommand(spec);
            }
        }

    }

    /**
     * Checks if the game is over.
     *
     * @return Returns true if game is over, else false.
     */
    public boolean checkIfIsOver() {
        if (!this.level.getPlayer().isAlive()) {
            return true;
        }
        if (this.commands.isEmpty()) {
            for (GameObject object : this.level.getObjektit()) {
                if (object instanceof Enemy) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

}
