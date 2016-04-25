package spaceshooter.managers;

import java.util.PriorityQueue;
import spaceshooter.commands.Command;
import spaceshooter.commands.SpawnEnemyCommand;
import spaceshooter.dom.Level;
import spaceshooter.dom.enemys.Mine;
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

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

}
