
package com.tsg.unittesting.arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author chelseamiller
 */
public class ArrayExerciseETest {
    
    public ArrayExerciseETest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of camelCaseIt method, of class ArrayExerciseE.
     * camelCaseIt( {"llama", "llama", "duck"}  ) ->  "llamaLlamaDuck"
     * camelCaseIt( {"lambs", "eat", "oats", "and", "does", "eat", "oats"}  ) ->  "lambsEatOatsAndDoesEatOats"
     * camelCaseIt( {"DO", "OR", "DO", "NOT", "THERE", "IS", "NO", "TRY"}  ) ->  "doOrDoNotThereIsNoTry"
     */
    @Test
    public void testCamelCaseItLlama() {
        
        String[] words = {"llama", "llama", "duck"};
        String expResult = "llamaLlamaDuck";
        String result = ArrayExerciseE.camelCaseIt(words);
        assertEquals(expResult, result);
      
    }
    @Test
    public void testCamelCaseItLambs() {
      
        String[] words = {"lambs", "eat", "oats", "and", "does", "eat", "oats"};
        String expResult = "lambsEatOatsAndDoesEatOats";
        String result = ArrayExerciseE.camelCaseIt(words);
        assertEquals(expResult, result);
      
    }
    @Test
    public void testCamelCaseItDo() {
        
        String[] words = {"DO", "OR", "DO", "NOT", "THERE", "IS", "NO", "TRY"};
        String expResult = "doOrDoNotThereIsNoTry";
        String result = ArrayExerciseE.camelCaseIt(words);
        assertEquals(expResult, result);
      
    }
    
}
