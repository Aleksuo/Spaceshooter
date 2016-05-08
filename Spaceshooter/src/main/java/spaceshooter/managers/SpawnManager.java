/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.managers;

import java.util.HashMap;
import java.util.Map;
import spaceshooter.commands.SpawnEnemyCommand;
import spaceshooter.dom.enemys.Enemy;
import spaceshooter.dom.Level;
import spaceshooter.dom.enemys.Mine;
import spaceshooter.dom.Spawner;
import spaceshooter.dom.enemys.Saucer;

/**
 * Class that manages spawners.
 *
 */
public class SpawnManager {

    private Map<Integer, Spawner> spawnerMap;
    private Level level;

    /**
     * Constructor for SpawnManager.
     *
     * @param level Current level.
     */
    public SpawnManager(Level level) {
        this.level = level;
        this.spawnerMap = new HashMap<Integer, Spawner>();
        createSpawners();

    }

    /**
     * Creates spawners for spawnable enemys.
     */
    public void createSpawners() {
        this.spawnerMap.put(1, new Spawner(new Mine(0, 0, 10, 10, 32, 32)));
        this.spawnerMap.put(2, new Spawner(new Saucer(0, 0, 5, 5, 32, 32)));
    }

    /**
     * Consumes SpawnEnemyCommands and spawns enemys.
     *
     * @param spec Command to be consumed.
     */
    public void handleSpawnCommand(SpawnEnemyCommand spec) {
        Enemy enemy = this.spawnerMap.get(spec.getEnemyId())
                .spawnEnemy(spec.getX(), spec.getY());
        this.level.addObject(enemy);
    }
}
