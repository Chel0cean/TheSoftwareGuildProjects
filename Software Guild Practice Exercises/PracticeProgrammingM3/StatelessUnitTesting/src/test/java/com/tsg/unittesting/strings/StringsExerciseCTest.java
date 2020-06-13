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
public class StringsExerciseCTest {
    
    public StringsExerciseCTest() {
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
     * Test of removeTheVowels method, of class StringsExerciseC.
     *  removeTheVowels( "truncate" ) ->  "trnct"
     * removeTheVowels( "squashed" ) ->  "sqshd"
     * removeTheVowels( "compressed" ) ->  "cmprssd"
     */
    @Test
    public void testRemoveTheVowelsTruncate() {
        String word = "truncate";
        String expResult = "trnct";
        String result = StringsExerciseC.removeTheVowels(word);
        assertEquals(expResult, result);
     }
    @Test
    public void testRemoveTheVowelsSquashed() {
        String word = "squashed";
        String expResult = "sqshd";
        String result = StringsExerciseC.removeTheVowels(word);
        assertEquals(expResult, result);
     }
    @Test
    public void testRemoveTheVowelsCompressed() {
        String word = "compressed";
        String expResult = "cmprssd";
        String result = StringsExerciseC.removeTheVowels(word);
        assertEquals(expResult, result);
     }
    
}
