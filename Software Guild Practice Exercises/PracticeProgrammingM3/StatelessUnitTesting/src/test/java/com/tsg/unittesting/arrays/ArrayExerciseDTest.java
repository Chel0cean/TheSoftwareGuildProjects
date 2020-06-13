/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class ArrayExerciseDTest {
    
    public ArrayExerciseDTest() {
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
     * Test of pointFree method, of class ArrayExerciseD.
     * * pointFree( [1.1, .22]  ) ->  22
     * pointFree( [ .039 , 20 , .005005 ]  ) ->  5005
     * pointFree( [ -9.9 , -700 , -.5  ]  ) ->  -5
     */
    
    @Test
    public void testPointFree22() {
        double[] numbers = {1.1, .22};
        int expResult = 22;
        int result = ArrayExerciseD.pointFree(numbers);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testPointFree5005() {
        
        double[] numbers = {.039 , 20 , .005005};
        int expResult =  5005;
        int result = ArrayExerciseD.pointFree(numbers);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testPointFreeNeg5() {
       
        double[] numbers = {-9.9 , -700 , -.5 };
        int expResult = -5;
        int result = ArrayExerciseD.pointFree(numbers);
        assertEquals(expResult, result);
     
    }
    
}
