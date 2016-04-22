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
public class PlayerTest {

    Player player;

    public PlayerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        player = new Player(0, 0, 0, 0);
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
    public void pelaajallaKolmeAlustaAlussa() {
        assertEquals(3, player.getShips());
    }

    @Test
    public void pelaajallaKolmeLataustaAlussa() {
        assertEquals(3, player.getCharges());
    }

    @Test
    public void pelaajaElossaLuonnissa() {
        assertEquals(true, player.isAlive());
    }

    @Test
    public void tormaysViholliseenVahentaaAluksia() {
        Enemy dummy = new Mine(0, 0, 0, 0, 0, 0);
        player.onCollision(dummy);
        assertEquals(2, player.getShips());
        player.onCollision(dummy);
        assertEquals(1, player.getShips());
    }

    @Test
    public void tormaysPaivitykseenPaivittaaAsetta() {
        this.player.onCollision(new Update(0, 0, 0, 0, 0, 0));
        assertEquals(1, this.player.getWeapon().getUpgrades());

    }

    @Test
    public void pelaajaEiElossaAlustenLoppuessa() {
        Enemy dummy = new Mine(0, 0, 0, 0, 0, 0);
        player.onCollision(dummy);
        player.onCollision(dummy);
        player.onCollision(dummy);
        assertEquals(false, player.isAlive());
    }

}
