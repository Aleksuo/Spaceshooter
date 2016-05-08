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
public class ShieldTest {
    private Shield shield;
    
    public ShieldTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.shield = new Shield(0,0,0,0,0,0,3,new Player(0,0,0,0));
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
        assertEquals(3,this.shield.getTicks());
        assertNotNull(this.shield.getParent());
    }
    
    @Test
    public void tickVahentaaTickeja(){
        this.shield.tick();
        assertEquals(2,this.shield.getTicks());
        this.shield.tick();
        this.shield.tick();
        assertEquals(0, this.shield.getTicks());
    }
    
    @Test
    public void tuhoutuuKunTickitNolla(){
        this.shield.tick();
        this.shield.tick();
        this.shield.tick();
        assertEquals(false,this.shield.isAlive());
    }
}
