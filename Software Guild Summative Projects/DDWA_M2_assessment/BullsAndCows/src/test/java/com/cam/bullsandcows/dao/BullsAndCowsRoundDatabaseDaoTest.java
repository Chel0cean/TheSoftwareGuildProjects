package com.cam.bullsandcows.dao;

import com.cam.bullsandcows.TestApplicationConfiguration;
import com.cam.bullsandcows.dto.Game;
import com.cam.bullsandcows.dto.Round;
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
public class BullsAndCowsRoundDatabaseDaoTest {

    @Autowired
    BullsAndCowsRoundDatabaseDao instance;

    @Autowired
    BullsAndCowsGameDao instance2;

    public BullsAndCowsRoundDatabaseDaoTest() {
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
     * Test of findRoundsByGameId method, of class BullsAndCowsRoundDatabaseDao.
     *
     * @throws com.cam.bullsandcows.dao.DataNotFoundException
     */
    @Test
    public void testFindRoundsByGameId() throws DataNotFoundException {
        System.out.println("findRoundsByGameId");

        Game newGame = new Game();
        newGame.setAnswer("1234");
        newGame.setStatus(true);
        newGame = instance2.add(newGame);

        Round roundOne = new Round();

        int gameId = newGame.getId();

        int idOne = 1;
        String guessOne = "2345";
        roundOne.setId(idOne);
        roundOne.setGameId(gameId);
        roundOne.setGuess(guessOne);

        instance.add(roundOne);

        Round roundTwo = new Round();

        int idTwo = 2;
        String guessTwo = "3456";
        roundTwo.setId(idTwo);
        roundTwo.setGameId(2);
        roundTwo.setGuess(guessTwo);

        instance.add(roundTwo);

        List<Round> result = instance.findRoundsByGameId(gameId);
        assertTrue(result.contains(roundOne) && result.size() == 1);
    }

    /**
     * Test of add method, of class BullsAndCowsRoundDatabaseDao.
     *
     * @throws com.cam.bullsandcows.dao.DataNotFoundException
     */
    @Test
    public void testAddGet() throws DataNotFoundException {
        System.out.println("add/Get");

        Game newGame = new Game();
        newGame.setAnswer("1234");
        newGame.setStatus(true);
        newGame = instance2.add(newGame);

        Round roundOne = new Round();

        int gameId = newGame.getId();

        String guessOne = "2345";

        roundOne.setGameId(gameId);
        roundOne.setGuess(guessOne);

        Round addResult = instance.add(roundOne);

        assertEquals(addResult, roundOne);

        Round expResult = addResult;

        Round result = instance.findById(roundOne.getId());

        assertEquals(expResult, result);
    }

    /**
     * Test of getAll method, of class BullsAndCowsRoundDatabaseDao.
     *
     * @throws com.cam.bullsandcows.dao.DataNotFoundException
     */
    @Test
    public void testGetAll() throws DataNotFoundException {
        System.out.println("getAll");

        Game newGame = new Game();
        newGame.setAnswer("1234");
        newGame.setStatus(true);
        newGame = instance2.add(newGame);

        Round roundOne = new Round();

        int gameId = newGame.getId();

        String guessOne = "2345";
        roundOne.setGameId(gameId);
        roundOne.setGuess(guessOne);

       roundOne= instance.add(roundOne);

        Round roundTwo = new Round();

        int idTwo = 2;
        String guessTwo = "3456";
        roundTwo.setId(idTwo);
        roundTwo.setGameId(gameId);
        roundTwo.setGuess(guessTwo);

       roundTwo= instance.add(roundTwo);

        List<Round> result = instance.getAll();

       
        assertTrue(result.contains(roundTwo));
        assertTrue(result.contains(roundOne));
    }



    /**
     * Test of update method, of class BullsAndCowsRoundDatabaseDao.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");

        Game newGame = new Game();
        newGame.setAnswer("1234");
        newGame.setStatus(true);
        newGame = instance2.add(newGame);

        Round roundOne = new Round();

        int gameId = newGame.getId();

        
        String guessOne = "2345";
        
        roundOne.setGameId(gameId);
        roundOne.setGuess(guessOne);

       roundOne= instance.add(roundOne);

        String guessTwo = "4536";

        roundOne.setGuess(guessTwo);

        instance.update(roundOne);

        assertTrue(roundOne.getGuess().equals(guessTwo));
    }

    /**
     * Test of deleteById method, of class BullsAndCowsRoundDatabaseDao.
     */
    @Test
    public void testDeleteById() throws DataNotFoundException {
        System.out.println("deleteById");

        Game newGame = new Game();
        newGame.setAnswer("1234");
        newGame.setStatus(true);
        newGame = instance2.add(newGame);

        Round roundOne = new Round();

        int gameId = newGame.getId();

       
        String guessOne = "2345";
       
        roundOne.setGameId(gameId);
        roundOne.setGuess(guessOne);

        roundOne=instance.add(roundOne);

        
        assertTrue(instance.deleteById(roundOne.getId()));
      
    }

}
