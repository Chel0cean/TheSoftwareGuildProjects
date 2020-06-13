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
public class LogicExerciseBTest {
    
    public LogicExerciseBTest() {
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
     * Test of placeOf method, of class LogicExerciseB.
     */
    @Test
    public void testPlaceOf1() {
        System.out.println("placeOf");
        int place = 1;
        LogicExerciseB instance = new LogicExerciseB();
        String expResult = "1st";
        String result = instance.placeOf(place);
        assertEquals(expResult, result);
    }
    @Test
    public void testPlaceOf3() {
        System.out.println("placeOf");
        int place = 3;
        LogicExerciseB instance = new LogicExerciseB();
        String expResult = "3rd";
        String result = instance.placeOf(place);
        assertEquals(expResult, result);
    }
    @Test
    public void testPlaceOf22() {
        System.out.println("placeOf");
        int place = 22;
        LogicExerciseB instance = new LogicExerciseB();
        String expResult = "22nd";
        String result = instance.placeOf(place);
        assertEquals(expResult, result);
    }
    @Test
    public void testPlaceOf11() {
        System.out.println("placeOf");
        int place = 11;
        LogicExerciseB instance = new LogicExerciseB();
        String expResult = "11th";
        String result = instance.placeOf(place);
        assertEquals(expResult, result);
    }
    
}
