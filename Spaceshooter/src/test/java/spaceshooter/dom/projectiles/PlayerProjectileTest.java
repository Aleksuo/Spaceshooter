/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom.projectiles;

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
public class PlayerProjectileTest {
    private PlayerProjectile projectile;
    
    public PlayerProjectileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.projectile = new PlayerProjectile(0,0,0,0,0,0,0);
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
     public void tormatessaViholliseenAmmusTuhoutuu() {
     this.projectile.onCollision(new Mine(0, 0, 0, 0, 0, 0));
     assertEquals(false, this.projectile.isAlive());
     }
}
