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
public class WeaponTest {

    private Weapon weapon;

    public WeaponTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.weapon = new Weapon(new Player(0, 0, 0, 0), 10, 25);
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
    public void aseLuodaanOikein() {
        assertEquals(10, this.weapon.getFirerate());
        assertEquals(25, this.weapon.getDamage());
    }

    @Test
    public void vahinkoEiVoiOllaNegatiivinen() {
        this.weapon.setDamage(-10);
        assertEquals(25, this.weapon.getDamage());
    }

    @Test
    public void vahinkoEiVoiOllaNolla() {
        this.weapon.setDamage(0);
        assertEquals(25, this.weapon.getDamage());
    }

    @Test
    public void kunnollinenVahinkoArvoKelpaa() {
        this.weapon.setDamage(5);
        assertEquals(5, this.weapon.getDamage());
    }

    @Test
    public void tulitusnopeusEiVoiOllaNegatiivinen() {
        this.weapon.setFirerate(-10);
        assertEquals(10, this.weapon.getFirerate());

    }

    @Test
    public void tulitusnopeusEiVoiOllaNolla() {
        this.weapon.setFirerate(0);
        assertEquals(10, this.weapon.getFirerate());
    }

    @Test
    public void kunnollinenTulitusnopeusArvoKelpaa() {
        this.weapon.setFirerate(20);
        assertEquals(20, this.weapon.getFirerate());
    }
}
