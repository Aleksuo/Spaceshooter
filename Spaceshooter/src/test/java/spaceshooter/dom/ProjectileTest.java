/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

import spaceshooter.dom.enemys.Mine;
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
public class ProjectileTest {

    private Projectile projectile;

    public ProjectileTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.projectile = new Projectile(0, 0, 0, 0, 0, 0, 15);
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
    public void konstruktoriLuoOikein() {

    }

    @Test
    public void vahinkoEiVoiOllaNegatiivinen() {
        this.projectile.setDamage(-10);
        assertEquals(15, this.projectile.getDamage());
    }

    @Test
    public void vahinkoEiVoiOllaNolla() {
        this.projectile.setDamage(0);
        assertEquals(15, this.projectile.getDamage());
    }

    @Test
    public void kunnollinenVahinkoArvoAsetetaan() {
        this.projectile.setDamage(25);
        assertEquals(25, this.projectile.getDamage());
    }

   /* @Test
    public void tormatessaViholliseenAmmusTuhoutuu() {
        this.projectile.onCollision(new Mine(0, 0, 0, 0, 0, 0));
        assertEquals(false, this.projectile.isAlive());
    }
    */
}
