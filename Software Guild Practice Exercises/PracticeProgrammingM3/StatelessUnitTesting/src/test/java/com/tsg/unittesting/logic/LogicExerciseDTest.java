/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.unittesting.logic;

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
public class LogicExerciseDTest {
    
    public LogicExerciseDTest() {
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
     * Test of isFirstTheFirst method, of class LogicExerciseD.
     *  isFirstTheFirst( 'a' , 'b'  ) ->  true
     * isFirstTheFirst( 'O' , 'X'  ) ->  true
     * isFirstTheFirst( 'Z' , 'z'   ) -> false
     */
    @Test
    public void testIsFirstTheFirstA() {
        char letterOne = 'a';
        char letterTwo = 'b';
        boolean expResult = true;
        boolean result = LogicExerciseD.isFirstTheFirst(letterOne, letterTwo);
        assertEquals(expResult, result);
        }
     @Test
    public void testIsFirstTheFirstO() {
        char letterOne = 'O';
        char letterTwo = 'X';
        boolean expResult = true;
        boolean result = LogicExerciseD.isFirstTheFirst(letterOne, letterTwo);
        assertEquals(expResult, result);
        }
     @Test
    public void testIsFirstTheFirstZ() {
        char letterOne = 'Z';
        char letterTwo = 'z';
        boolean expResult = false;
        boolean result = LogicExerciseD.isFirstTheFirst(letterOne, letterTwo);
        assertEquals(expResult, result);
        }
}
