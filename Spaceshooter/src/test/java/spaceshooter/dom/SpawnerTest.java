/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spaceshooter.dom.enemys.Mine;

/**
 *
 * @author Aleksi
 */
public class SpawnerTest {
    private Spawner spawner;
    
    public SpawnerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.spawner = new Spawner(new Mine(0,0,10,10,32,32));
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void luodaanOikein(){
        assertNotNull(this.spawner.getPrototype());
    }
    
    @Test
    public void spawnToimiiOikein(){
        assertThat(this.spawner.spawnEnemy(10, 10), instanceOf(Mine.class));
        Mine mine = (Mine)this.spawner.spawnEnemy(11, 12);
        assertEquals(11,mine.getPosX(),0.0);
        assertEquals(12,mine.getPosY(), 0.0);
        assertEquals(10,mine.getVelX(),0.0);
        assertEquals(10,mine.getVelY(), 0.0);
        assertEquals(32,mine.getWidth());
        assertEquals(32,mine.getHeight());
        
    }
}
