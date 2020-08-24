
package com.cam.bullsandcows.service;

import com.cam.bullsandcows.TestApplicationConfiguration;
import com.cam.bullsandcows.dao.DataNotFoundException;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
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
public class BullsAndCowsServiceTest {
    
     @Autowired
    BullsAndCowsServiceImpl instance;

    public BullsAndCowsServiceTest() {
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
     * Test of generateAnswer method, of class BullsAndCowsServiceImpl.
     */
    
    
    @Test
    public void testGenerateAnswer() {
        System.out.println("generateAnswer");
       
        String result = instance.generateAnswer();
        String a = result.substring(0, 1);
        String b = result.substring(1, 2);
        String c = result.substring(2, 3);
        String d = result.substring(3, 4);
        assertTrue(!a.equals(b) || !a.equals(c) || !a.equals(d));
        assertTrue(!b.equals(c) || !b.equals(d));
        assertTrue(!c.equals(d));
        System.out.println(result);

    }

    /**
     * Test of generateScore method, of class BullsAndCowsServiceImpl.
     */
    @Test
    public void testGenerateScore() throws DataNotFoundException, BadUserInputException {
        System.out.println("generateScore");
        String answer = "3214";
        String guessOne = "5678";
        String expScoreOne = "e:0:p:0";
        
        
        String guessTwo = "4123";
        String expScoreTwo = "e:0:p:4";
        
      
        String guessThree = "3214";
        String expScoreThree = "e:4:p:0";
        
     
        String guessFour = "3241";
        String expScoreFour = "e:2:p:2";

       
      
        String resultOne = instance.generateScore(answer, guessOne);
       
        
        String resultTwo = instance.generateScore(answer, guessTwo);
        
        
        String resultThree = instance.generateScore(answer, guessThree);
       
        
        String resultFour = instance.generateScore(answer, guessFour);
       
        
        assertEquals(expScoreOne, resultOne);
        assertEquals(expScoreTwo, resultTwo);
        assertEquals(expScoreThree, resultThree);
        assertEquals(expScoreFour, resultFour);
        
    }

}
