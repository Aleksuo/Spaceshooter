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
import spaceshooter.logiikka.Pistelaskuri;

/**
 *
 * @author Aleksi
 */
public class PistelaskuriTest {
    Pistelaskuri laskuri;
    
    public PistelaskuriTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.laskuri = new Pistelaskuri();
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
    public void eiPisteitaAlussa(){
        assertEquals(0,laskuri.getPisteet());
    }
    
    @Test
    public void lisaysLisaaPisteita(){
        laskuri.lisaa(100);
        assertEquals(100, laskuri.getPisteet());
        laskuri.lisaa(150);
        assertEquals(250, laskuri.getPisteet());
    }
    
    @Test
    public void lisaysEiVahennaPisteita(){
        laskuri.lisaa(-100);
        assertEquals(0, laskuri.getPisteet());
        laskuri.lisaa(200);
        laskuri.lisaa(-150);
        assertEquals(200, laskuri.getPisteet());
    }
    
    @Test
    public void vahennysVahentaaPisteita(){
        
    }
}
