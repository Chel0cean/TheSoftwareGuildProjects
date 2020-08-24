package com.cam.bullsandcows.dao;

import com.cam.bullsandcows.TestApplicationConfiguration;
import com.cam.bullsandcows.dto.Game;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author chelseamiller
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class BullsAndCowsGameDatabaseDaoTest {

    
    

    @Autowired
    BullsAndCowsGameDao instance;

    public BullsAndCowsGameDatabaseDaoTest() {
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
     * Test of add method, of class BullsAndCowsGameDatabaseDao.
     * @throws com.cam.bullsandcows.dao.DataNotFoundException
     */
    @Test
    public void testAddGet() throws DataNotFoundException {
        System.out.println("add");

        Game newGame = new Game();
        newGame.setAnswer("1234");
        newGame.setStatus(true);

        Game newGame2 = new Game();
        newGame2.setAnswer("4567");
        newGame2.setStatus(false);

        Game expResult = newGame;
        Game result = instance.add(newGame);
        assertEquals(expResult, result);

        int id = result.getId();

        Game findResult = instance.findById(id);

        assertEquals(expResult, findResult);
    }

    /**
     * Test of getAll method, of class BullsAndCowsGameDatabaseDao.
     * @throws com.cam.bullsandcows.dao.DataNotFoundException
     */
    @Test
    public void testGetAll() throws DataNotFoundException {
        System.out.println("getAll");

        Game newGame = new Game();
        newGame.setAnswer("1234");
        newGame.setStatus(true);

        Game newGame2 = new Game();
        newGame2.setAnswer("4567");
        newGame2.setStatus(false);

        instance.add(newGame);
        instance.add(newGame2);

        List<Game> result = instance.getAll();

        assertTrue(result.contains(newGame));
        assertTrue(result.contains(newGame2));
    }

    /**
     * Test of update method, of class BullsAndCowsGameDatabaseDao.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        String oldAnswer = "1234";
        String newAnswer = "2345";

        Game newGame = new Game();
        newGame.setAnswer(oldAnswer);
        newGame.setStatus(true);
        instance.add(newGame);

        newGame.setAnswer(newAnswer);

        instance.update(newGame);

        assertTrue(newGame.getAnswer().equals(newAnswer));
    }

    /**
     * Test of deleteById method, of class BullsAndCowsGameDatabaseDao.
     */
    @Test
    public void testDeleteById() throws DataNotFoundException {
        System.out.println("deleteById");

        Game newGame = new Game();
        newGame.setAnswer("1234");
        newGame.setStatus(true);

        newGame = instance.add(newGame);

        Game newGame2 = new Game();
        newGame2.setAnswer("4567");
        newGame2.setStatus(false);

        instance.add(newGame2);

        instance.deleteById(newGame.getId());

        List<Game> allGames = instance.getAll();

        assertFalse(allGames.contains(newGame));
       
    }

}
