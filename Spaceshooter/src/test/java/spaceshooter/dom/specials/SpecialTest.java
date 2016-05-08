/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom.specials;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spaceshooter.dom.Player;

/**
 *
 * @author Aleksi
 */
public class SpecialTest {
    private Special special;
    public SpecialTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.special = new Special(new Player(0,0,0,0), 3);
        
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
    public void erikoistaitoLuodaanOikein(){
        assertEquals(3,this.special.getCharges());
        assertEquals(3,this.special.getDelay(), 0.0);
        assertNotNull(this.special.getParent());
        assertNotNull(this.special.getTimer());
    }
    
    @Test
    public void chargeLisaaLatauksia(){
        this.special.setCharges(0);
        this.special.charge();
        assertEquals(1,this.special.getCharges());
        this.special.charge();
        assertEquals(2,this.special.getCharges());
        this.special.charge();
        assertEquals(3,this.special.getCharges());
    }
    
    @Test
    public void latauksetEivatVoiMennaYliKolmen(){
        this.special.charge();
        this.special.charge();
        assertEquals(3, this.special.getCharges());
    }
    
    @Test
    public void dischargeVahentaaLatauksia(){
        this.special.discharge();
        assertEquals(2,this.special.getCharges());
        this.special.discharge();
        assertEquals(1,this.special.getCharges());
        this.special.discharge();
        assertEquals(0,this.special.getCharges());
    }
    
    @Test
    public void latauksetEivatVoiMennaAlleNollan(){
        this.special.discharge();
        this.special.discharge();
        this.special.discharge();
        this.special.discharge();
        this.special.discharge();
        assertEquals(0,this.special.getCharges());
    }
}
