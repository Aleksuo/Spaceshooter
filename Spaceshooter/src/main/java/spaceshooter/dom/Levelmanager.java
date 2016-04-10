/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import java.util.PriorityQueue;
import spaceshooter.commands.Command;
import spaceshooter.commands.SpawnEnemyCommand;
import spaceshooter.util.LevelLoader;
import spaceshooter.util.Timer;

/**
 *
 * @author Aleksi
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

    public void handleCommands() {
        
            while ((!this.commands.isEmpty())
                    &&(this.timer.elapsedTimeInSeconds() >= this.commands.peek().getTime())) {
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
