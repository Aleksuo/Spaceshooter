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
public class PelaajaTest {

    Pelaaja pelaaja;

    public PelaajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pelaaja = new Pelaaja(0, 0, 0, 0);
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
        assertEquals(3, pelaaja.getAlukset());
    }

    @Test
    public void pelaajaElossaLuonnissa() {
        assertEquals(true, pelaaja.isAlive());
    }

    @Test
    public void tormaysViholliseenVahentaaAluksia() {
        Vihollinen dummy = new Vihollinen(0, 0, 0, 0, 0, 0);
        pelaaja.onCollision(dummy);
        assertEquals(2, pelaaja.getAlukset());
        pelaaja.onCollision(dummy);
        assertEquals(1, pelaaja.getAlukset());
    }

    @Test
    public void pelaajaEiElossaAlustenLoppuessa() {
        Vihollinen dummy = new Vihollinen(0, 0, 0, 0, 0, 0);
        pelaaja.onCollision(dummy);
        pelaaja.onCollision(dummy);
        pelaaja.onCollision(dummy);
        assertEquals(false, pelaaja.isAlive());
    }
}
