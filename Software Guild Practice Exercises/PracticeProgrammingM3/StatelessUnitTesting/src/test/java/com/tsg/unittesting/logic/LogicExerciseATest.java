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
public class LogicExerciseATest {
    
    public LogicExerciseATest() {
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
     * Test of friendlyGreeting method, of class LogicExerciseA.
     * friendlyGreeting( "Goofus" , false ) ->   "hi"
     * friendlyGreeting( "Gallant" , true ) ->   "Hello, Gallant!"
     * friendlyGreeting( null , false ) ->   "..."
     */
    @Test
    public void testFriendlyGreetingGoofus() {
        String visitorName = "Goofus";
        boolean isFriend = false;
        String expResult = "hi";
        String result = LogicExerciseA.friendlyGreeting(visitorName, isFriend);
        assertEquals(expResult, result);
    }
    @Test
    public void testFriendlyGreetingGallant() {
        String visitorName = "Gallant";
        boolean isFriend = true;
        String expResult = "Hello, Gallant!";
        String result = LogicExerciseA.friendlyGreeting(visitorName, isFriend);
        assertEquals(expResult, result);
    }
    @Test
    public void testFriendlyGreetingNull() {
        String visitorName = null;
        boolean isFriend = false;
        String expResult = "...";
        String result = LogicExerciseA.friendlyGreeting(visitorName, isFriend);
        assertEquals(expResult, result);
    }
}
