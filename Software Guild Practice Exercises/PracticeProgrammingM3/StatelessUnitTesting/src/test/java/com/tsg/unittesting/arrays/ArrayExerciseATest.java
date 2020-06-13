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
public class ArrayExerciseATest {
    
    public ArrayExerciseATest() {
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
     * Test of maxOfArray method, of class ArrayExerciseA.
     */
    @Test
    public void testMaxOfArray() {
        System.out.println("maxOfArray");
        int[] numbers = null;
        int expResult = 0;
        int result = ArrayExerciseA.maxOfArray(numbers);
        assertEquals(expResult, result);
      
    }
    
    @Test
    public void testCountToTenArray(){
        //arrange
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int expectedResult = 10;
        //act
        int actualResult = ArrayExerciseA.maxOfArray(array);
        
        
        //assert
        
        assertEquals(expectedResult, actualResult);
    }
}
