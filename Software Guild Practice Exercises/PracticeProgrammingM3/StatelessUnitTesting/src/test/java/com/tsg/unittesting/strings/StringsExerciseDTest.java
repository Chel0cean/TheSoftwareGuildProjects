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
public class StringsExerciseDTest {
    
    public StringsExerciseDTest() {
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
     * Test of simpleReverse method, of class StringsExerciseD.
     * simpleReverse( "fun times" ) ->  "semit nuf"
     * simpleReverse( "llama llama duck" ) ->  "kcud amall amall"
     * simpleReverse( "hannah" ) ->  "hannah"
     */
    @Test
    public void testSimpleReverseFun() {
        String phrase = "fun times";
        String expResult = "semit nuf";
        String result = StringsExerciseD.simpleReverse(phrase);
        assertEquals(expResult, result);
    }
    @Test
    public void testSimpleReverseLlama () {
        String phrase = "llama llama duck";
        String expResult = "kcud amall amall";
        String result = StringsExerciseD.simpleReverse(phrase);
        assertEquals(expResult, result);
    }
    @Test
    public void testSimpleReverseHannah() {
        String phrase = "hannah";
        String expResult = "hannah";
        String result = StringsExerciseD.simpleReverse(phrase);
        assertEquals(expResult, result);
    }
    
}
