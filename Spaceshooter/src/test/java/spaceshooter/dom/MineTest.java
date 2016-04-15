/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aleksi
 */
public class MineTest {

    private Mine mine;

    public MineTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.mine = new Mine(0, 0, 0, 0, 0, 0);
        this.mine.setHitpoints(50);
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
    public void tormatessaAmmukseenHpVaheneeAmmuksenVahingonVerran() {
        this.mine.onCollision(new Projectile(0, 0, 0, 0, 0, 0, 20));
        assertEquals(30, this.mine.getHitpoints());
    }

    @Test
    public void tuhoutuuJosTormayksenJalkeenHpOnNolla() {
        this.mine.onCollision(new Projectile(0, 0, 0, 0, 0, 0, 50));
        assertEquals(false, this.mine.isAlive());
    }

    @Test
    public void tuhoutuuJosTormayksenJalkeenHponPienempiKuinNolla() {
        this.mine.onCollision(new Projectile(0, 0, 0, 0, 0, 0, 100));
        assertEquals(false, this.mine.isAlive());
    }
}
