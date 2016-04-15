/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.command;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spaceshooter.commands.SpawnEnemyCommand;

/**
 *
 * @author Aleksi
 */
public class SpawnEnemyCommandTest {

    public SpawnEnemyCommandTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
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
    public void komentoLuodaanOikein() {
        SpawnEnemyCommand command = new SpawnEnemyCommand(2, 3, 10, 11);
        assertEquals(2, command.getTime(), 0.0);
        assertEquals(3, command.getEnemyId());
        assertEquals(10, command.getX(), 0.0);
        assertEquals(11, command.getY(), 0.0);
    }

}
