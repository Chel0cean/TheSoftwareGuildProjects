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
public class StringsExerciseATest {
    
    public StringsExerciseATest() {
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
     * Test of yell method, of class StringsExerciseA.
     * * Ex:
     * yell( "Hello there." ) ->  "HELLO THERE."
     * yell( "shhhhhhhhhhhh" ) ->  SHHHHHHHHHHHH
     * yell( "AAaAAAaAAAaaAAHHHH" ) ->  "AAAAAAAAAAAAAAHHHH"
     * 
     */
    @Test
    public void testYellHello() {
        System.out.println("yell");
        String word = "Hello there.";
        String expResult = "HELLO THERE.";
        String result = StringsExerciseA.yell(word);
        assertEquals(expResult, result);
      }
    @Test
    public void testYellShhh() {
        System.out.println("yell");
        String word = "shhhhhhhhhhhh";
        String expResult = "SHHHHHHHHHHHH";
        String result = StringsExerciseA.yell(word);
        assertEquals(expResult, result);
      }
    @Test
    public void testYellAAaA() {
        System.out.println("yell");
        String word = "AAaAAAaAAAaaAAHHHH";
        String expResult = "AAAAAAAAAAAAAAHHHH";
        String result = StringsExerciseA.yell(word);
        assertEquals(expResult, result);
      }
    
}
