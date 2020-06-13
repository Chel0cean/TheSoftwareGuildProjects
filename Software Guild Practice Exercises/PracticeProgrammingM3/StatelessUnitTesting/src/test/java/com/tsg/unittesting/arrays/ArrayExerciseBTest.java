
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
public class ArrayExerciseBTest {
    
    public ArrayExerciseBTest() {
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
     * Test of multiplyAll method, of class ArrayExerciseB.
     * multiplyAll( 5 , [ 1 , 2 , 3 , 4 , 5 ] ) ->  [ 5 , 10 , 15 , 20 , 25 ]
     * multiplyAll( 0 , [ 1 , 1 , 1 , 1 , 1  , 1 , 1 , 1 , 1 ] ) ->  [ 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ]
     * multiplyAll( -1 , [ -2 , 0 , 0 , 1 ] ) ->  [ 2 , 0 , 0 , -1 ]
     */
    @Test
    public void testMultiply5() {
        System.out.println("multiply5");
        int multiplier = 5;
        int[] numbers = { 1 , 2 , 3 , 4 , 5 };
        int[] expResult = { 5 , 10 , 15 , 20 , 25};
        int[] result = ArrayExerciseB.multiplyAll(multiplier, numbers);
        assertArrayEquals(expResult, result);
    }
    @Test
    public void testMultiply0() {
        System.out.println("multiply0");
        int multiplier = 0;
        int[] numbers = { 1 , 1 , 1 , 1 , 1  , 1 , 1 , 1 , 1 };
        int[] expResult = {0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 };
        int[] result = ArrayExerciseB.multiplyAll(multiplier, numbers);
        assertArrayEquals(expResult, result);
    }
      @Test
    public void testMultiplyNeg1() {
        System.out.println("multiply-1");
        int multiplier = -1;
        int[] numbers = {-2 , 0 , 0 , 1 };
        int[] expResult = {2 , 0 , 0 , -1 };
        int[] result = ArrayExerciseB.multiplyAll(multiplier, numbers);
        assertArrayEquals(expResult, result);
    }
    
}

