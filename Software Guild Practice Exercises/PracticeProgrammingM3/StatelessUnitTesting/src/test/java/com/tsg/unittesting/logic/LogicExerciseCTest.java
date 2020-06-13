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
public class LogicExerciseCTest {
    
    public LogicExerciseCTest() {
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
     * Test of goWalky method, of class LogicExerciseC.
     *  goWalky( true, false, true, true, 75  ) ->  true
     * goWalky( false, true, false, false, 50  ) ->  true
     * goWalky( false, false, false, false, 30  ) ->  false
     */
    @Test
    public void testGoWalky75() {
        boolean isDark = true;
        boolean haveFlashlight = true;
        boolean isRaining = true;
        boolean haveUmbrella = true;
        int degreesFarenheit = 75;
        boolean expResult = true;
        boolean result = LogicExerciseC.goWalky(isDark, haveFlashlight, isRaining, haveUmbrella, degreesFarenheit);
        assertEquals(expResult, result);     
    }
     @Test
    public void testGoWalky50() {
        boolean isDark = false;
        boolean haveFlashlight = false;
        boolean isRaining = false;
        boolean haveUmbrella = false;
        int degreesFarenheit = 50;
        boolean expResult = true;
        boolean result = LogicExerciseC.goWalky(isDark, haveFlashlight, isRaining, haveUmbrella, degreesFarenheit);
        assertEquals(expResult, result);     
    }
     @Test
    public void testGoWalky30() {
        boolean isDark = false;
        boolean haveFlashlight = false;
        boolean isRaining = false;
        boolean haveUmbrella = false;
        int degreesFarenheit = 30;
        boolean expResult = false;
        boolean result = LogicExerciseC.goWalky(isDark, haveFlashlight, isRaining, haveUmbrella, degreesFarenheit);
        assertEquals(expResult, result);     
    }
    
}
