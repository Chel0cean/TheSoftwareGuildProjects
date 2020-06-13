/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.unittesting.strings;

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
public class StringsExerciseETest {
    
    public StringsExerciseETest() {
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
     * Test of containsTheOther method, of class StringsExerciseE.
     * * containsTheOther( "one", "tone" ) ->  true
     * containsTheOther( "same", "same" ) ->  false
     * containsTheOther( "fancypants", "pants" ) ->  true
     * containsTheOther( "llama", "duck" ) ->  false
     * 
     */
    @Test
    public void testContainsTheOtherOne() {
        String one = "one";
        String two = "tone";
        boolean expResult = true;
        boolean result = StringsExerciseE.containsTheOther(one, two);
        assertEquals(expResult, result);
    }
    @Test
    public void testContainsTheOtherSame() {
        String one = "same";
        String two = "same";
        boolean expResult = false;
        boolean result = StringsExerciseE.containsTheOther(one, two);
        assertEquals(expResult, result);
    }
    @Test
    public void testContainsTheOtherFancypants() {
        String one = "fancypants";
        String two = "pants";
        boolean expResult = true;
        boolean result = StringsExerciseE.containsTheOther(one, two);
        assertEquals(expResult, result);
    }
    @Test
    public void testContainsTheOtherLlama() {
        String one = "llama";
        String two = "duck";
        boolean expResult = false;
        boolean result = StringsExerciseE.containsTheOther(one, two);
        assertEquals(expResult, result);
    }
    
}
