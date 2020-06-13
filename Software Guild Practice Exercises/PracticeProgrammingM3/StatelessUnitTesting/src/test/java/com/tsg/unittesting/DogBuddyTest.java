/*********************************
* The Software Guild
* Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
*********************************/
package com.tsg.unittesting;

import static com.tsg.unittesting.DogBuddy.howManyWoofs;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author ahill
 */
public class DogBuddyTest {

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    
    /*  Test Plan:
    **  howManyWoofs(10)   -> "Woof! Woof! Woof!"
    **  howManyWoofs(5)    -> "Woof! Woof!"
    **  howManyWoofs(2)    -> "Woof! Woof! Woof!"
    **  howManyWoofs(0)    -> "..."
    **  howManyWoofs(-10)  -> "..."
    **  howManyWoofs(-5)   -> "..."
    */
    
    @Test
    public void testTenBones() {
    	// The best way to test is to very clearly arrange your potential state
    	// inputs and outputs, then call the thing being tested,
    	// and then finally assert on the state or behaviours you want to result.
    
        // ARRANGE
        int numBones = 10;
        
        // ACT
        String woofs = howManyWoofs(10);
        
        // ASSERT - w/ Message
        String expectedWoofs = "Woof! Woof! Woof!";
        assertEquals(expectedWoofs, woofs, "Expected 3 Woofs w/ 10 bones");
    }
    
    @Test
    public void testFiveBones() {
    	// However, you can also merge some steps for speed of test implementations.
    	// but be careful about leaving off failure messages - it can make test failures
    	// pretty esoteric and unreadable.
    
    	// ARRANGE
        String expectedWoofs = "Woof! Woof!";
        // ACT & ASSERT - No msg
        assertEquals(expectedWoofs, howManyWoofs(5));
    }
    
    @Test
    public void testTwoBones() {
        // ARRANGE
        int numBones = 2;
        
        // ACT
        String woofs = howManyWoofs(numBones);
        
        // ASSERT - w/ Message
        String expectedWoofs = "Woof! Woof! Woof!";
        assertEquals(expectedWoofs, woofs, "Expected 3 Woofs w/ 2 bones");
    }
    
    @Test
    public void testZeroBones() {
        // ARRANGE
        int numBones = 0;
        
        // ACT
        String woofs = howManyWoofs(numBones);
        
        // ASSERT - w/ Message
        String expectedWoofs = "...";
        assertEquals(expectedWoofs, woofs, "Expected silence w/ 0 bones");
    }
    
    @Test
    public void testNegativeTenBones() {
        // ARRANGE
        int numBones = -10;
        
        // ACT
        String woofs = howManyWoofs(numBones);
        
        // ASSERT - w/ Message
        String expectedWoofs = "...";
        assertEquals(expectedWoofs, woofs, "Expected silence w/ -10 bones");
    }
    
    @Test
    public void testNegativeFiveBones() {
        // ARRANGE
        int numBones = -5;
        
        // ACT
        String woofs = howManyWoofs(numBones);
        
        // ASSERT - w/ Message
        String expectedWoofs = "...";
        assertEquals(expectedWoofs, woofs, "Expected silence w/ -5 bones");
    }

    /**
     * Test of howManyWoofs method, of class DogBuddy.
     */
    @Test
    public void testHowManyWoofs() {
        System.out.println("howManyWoofs");
        int numBones = 0;
        String expResult = "...";
        String result = DogBuddy.howManyWoofs(numBones);
        assertEquals(expResult, result);
        
    }
}
