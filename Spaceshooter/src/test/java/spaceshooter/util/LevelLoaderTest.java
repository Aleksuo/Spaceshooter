package spaceshooter.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.PriorityQueue;
import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spaceshooter.commands.Command;
import spaceshooter.commands.SpawnEnemyCommand;

/**
 *
 * @author Aleksi
 */
public class LevelLoaderTest {

    private LevelLoader levelLoader;

    public LevelLoaderTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.levelLoader = new LevelLoader();
    }

    @After
    public void tearDown() {
    }

    //1.0, SPAWN_ENEMY, 2, 30, 15
    @Test
    public void spawnEnemyCommandLuetaanOikein() {
        PriorityQueue<Command> commands = this.levelLoader.loadLevelFromFile("/TestResources/SpawnEnemyCommand1.txt");
        assertThat(commands.peek(), instanceOf(SpawnEnemyCommand.class));
        SpawnEnemyCommand c = (SpawnEnemyCommand) commands.poll();
        assertEquals(c.getTime(), 1.0, 0.0);
        assertEquals(c.getEnemyId(), 2);
        assertEquals(c.getX(), 30, 0.0);
        assertEquals(c.getY(), 15, 0.0);

    }
    /* 
     7.0, SPAWN_ENEMY, 1, 0, 0
     1.0, SPAWN_ENEMY, 1, 0, 0
     8.0, SPAWN_ENEMY, 1, 0, 0
     1.5, SPAWN_ENEMY, 1, 0, 0
     */

    @Test
    public void komentojenJarjestyksellaTiedostossaEiValia() {
        PriorityQueue<Command> commands = this.levelLoader.loadLevelFromFile("/TestResources/OrderTest.txt");
        assertEquals(1.0, commands.poll().getTime(), 0.0);
        assertEquals(1.5, commands.poll().getTime(), 0.0);
        assertEquals(7.0, commands.poll().getTime(), 0.0);
        assertEquals(8.0, commands.poll().getTime(), 0.0);
    }

}
