package spaceshooter.logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spaceshooter.logic.Scorecounter;

/**
 *
 * @author Aleksi
 */
public class ScorecounterTest {

    Scorecounter counter;

    public ScorecounterTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.counter = new Scorecounter();
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
    public void eiPisteitaAlussa() {
        assertEquals(0, counter.getScore());
    }

    @Test
    public void lisaysLisaaPisteita() {
        counter.add(100);
        assertEquals(100, counter.getScore());
        counter.add(150);
        assertEquals(250, counter.getScore());
    }

    @Test
    public void lisaysEiVahennaPisteita() {
        counter.add(-1);
        counter.add(-100);
        assertEquals(0, counter.getScore());
        counter.add(200);
        counter.add(-150);
        assertEquals(200, counter.getScore());
    }

    @Test
    public void vahennysVahentaaPisteita() {
        counter.add(500);
        counter.reduce(250);
        assertEquals(250, counter.getScore());
        counter.reduce(250);
        assertEquals(0, counter.getScore());
    }

    @Test
    public void vahennysEiLisaaPisteita() {
        counter.reduce(-200);
        assertEquals(0, counter.getScore());
    }

    @Test
    public void vahennysEiVahennaNegatiiviseksi() {
        counter.reduce(100);
        assertEquals(0, counter.getScore());
        counter.add(100);
        counter.reduce(150);
        assertEquals(0, counter.getScore());
    }

    @Test
    public void nollauksenJalkeenEiPisteita() {
        counter.add(400);
        counter.reset();
        assertEquals(0, counter.getScore());
    }
}
