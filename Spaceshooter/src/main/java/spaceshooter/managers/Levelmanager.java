package spaceshooter.managers;

import java.util.PriorityQueue;
import spaceshooter.commands.Command;
import spaceshooter.commands.SpawnEnemyCommand;
import spaceshooter.dom.Level;
import spaceshooter.dom.Mine;
import spaceshooter.util.LevelLoader;
import spaceshooter.util.Timer;

/**
 * Manager used to manage level related things
 *
 */
public class Levelmanager {

    private Level level;
    private LevelLoader levelLoader;
    private Timer timer;

    private PriorityQueue<Command> commands;

    public Levelmanager() {
        this.level = new Level();
        this.levelLoader = new LevelLoader();
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
        //System.out.println(this.commands.size());
        //System.out.println(this.timer.elapsedTimeInSeconds());
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

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
                SpawnEnemyCommand sec = (SpawnEnemyCommand) command;
                float x = sec.getX();
                float y = sec.getY();

                this.level.addObject((new Mine(x, y, 20, 20, 32, 32)));
            }
        }

    }

}
