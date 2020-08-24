
package com.cam.bullsandcows.dao;

import com.cam.bullsandcows.TestApplicationConfiguration;
import com.cam.bullsandcows.dto.Game;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author chelseamiller
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class BullsAndCowsInMemoryDaoTest {

    BullsAndCowsInMemoryDao instance = new BullsAndCowsInMemoryDao();

    public BullsAndCowsInMemoryDaoTest() {
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

    /**
     * Test of add method, of class BullsAndCowsInMemoryDao.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Game newGame = new Game();
        newGame.setAnswer("1234");
        newGame.setStatus(true);

        Game expResult = newGame;
        Game result = instance.add(newGame);
        assertEquals(expResult, result);
        System.out.println(newGame.getId());
    }

    /**
     * Test of getAll method, of class BullsAndCowsInMemoryDao.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");

        Game newGame = new Game();
        newGame.setAnswer("1234");
        newGame.setStatus(true);

        Game newGame2 = new Game();
        newGame2.setAnswer("4567");
        newGame2.setStatus(false);

        instance.add(newGame2);
        instance.add(newGame);
        List<Game> result = instance.getAll();
        assertTrue(result.contains(newGame));
        assertTrue(result.contains(newGame2));
    }

    /**
     * Test of findById method, of class BullsAndCowsInMemoryDao.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 2;

        Game newGame2 = new Game();
        newGame2.setId(2);
        newGame2.setAnswer("4567");
        newGame2.setStatus(false);

        Game expResult = newGame2;
        instance.add(newGame2);

        Game result = instance.findById(id);
        assertEquals(expResult, result);

    }

    /**
     * Test of update method, of class BullsAndCowsInMemoryDao.
     */
    @Test
    public void testUpdate() {

        System.out.println("update");
        
        Game newGame2 = new Game();
        String oldAnswer = "4567";
        String newAnswer = "2398";

        newGame2.setId(2);
        newGame2.setAnswer(oldAnswer);
        newGame2.setStatus(false);

        instance.add(newGame2);

        newGame2.setAnswer(newAnswer);
       

        boolean expResult = true;
        boolean result = instance.update(newGame2);
        assertEquals(expResult, result);
        }

    /**
     * Test of deleteById method, of class BullsAndCowsInMemoryDao.
     *
     */
    @Test
    public void testDeleteById() {
        System.out.println("deleteById");
        int id = 2;
        Game newGame2 = new Game();
        newGame2.setId(id);
        newGame2.setAnswer("4567");
        newGame2.setStatus(false);

        instance.add(newGame2);

        boolean expResult = true;
        boolean result = instance.deleteById(id);
        assertEquals(expResult, result);
        assertNull(instance.findById(2));
    }
}
