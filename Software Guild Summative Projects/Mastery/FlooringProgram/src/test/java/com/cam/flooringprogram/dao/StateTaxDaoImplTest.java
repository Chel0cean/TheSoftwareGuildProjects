/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cam.flooringprogram.dao;

import com.cam.flooringprogram.dto.State;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author chelseamiller
 */
public class StateTaxDaoImplTest {
    StateTaxDao testDao;
    String abbr, abbrTwo;
    State delusion, decay;    
    public StateTaxDaoImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws IOException {
        
             String testFile = "testState.txt";
        // Use the FileWriter to quickly blank the file
        new FileWriter(testFile);
        
          ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("applicationContext.xml");
    testDao = 
        ctx.getBean("stateDao", StateTaxDao.class);
        
        
       
        
        abbrTwo="dec";
        decay = new State(abbrTwo);
        decay.setName("decay");
       decay.setTaxRate(new BigDecimal ("12"));
        
       abbr="del";
       delusion = new State(abbr);
        delusion.setName("delusion");
       delusion.setTaxRate(new BigDecimal ("14"));
    }
    
    @AfterEach
    public void tearDown() {
    }

   

 

    /**
     * Test of editState method, of class StateTaxDaoImpl.
     * @throws java.lang.Exception
     */
    @Test
    public void testEditState() throws Exception {
       System.out.println("editState");
      
       testDao.createState(abbr, delusion);
       
       BigDecimal oldRate= delusion.getTaxRate();
       
        BigDecimal updatedRate = new BigDecimal("4");
    
        delusion.setTaxRate(updatedRate);
       
        
        
        testDao.editState(abbr, delusion);
        
       BigDecimal currentRate = delusion.getTaxRate();
        
       
        assertNotEquals(oldRate, currentRate);
    }

    /**
     * Test of removeState method, of class StateTaxDaoImpl.
     * @throws java.lang.Exception
     */
    @Test

    public void testRemoveState() throws Exception {
        System.out.println("removeState");
        
     testDao.createState(abbr, delusion);
        testDao.createState(abbrTwo, decay);
        List<State> firstResult =testDao.getAllStates();
        testDao.removeState(abbr);
       List<State> secondResult =testDao.getAllStates();
       
        assertNotEquals(firstResult, secondResult);
    }

    /**
     * Test of getState method, of class StateTaxDaoImpl.
    */
    @Test
    public void testAddGetState() throws Exception {
        System.out.println("addState");
       
           testDao.createState(abbr, delusion);
        
        System.out.println("getState");
        State expResult = delusion;
        State result = testDao.getState(abbr);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllStates method, of class StateTaxDaoImpl.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllStates() throws Exception {
        System.out.println("getAllStates");
   
        
             testDao.createState(abbr, delusion);
       testDao.createState(abbrTwo, decay);
        
        
        List<State> result = testDao.getAllStates();
        assertTrue(result.contains(delusion));
         assertTrue(result.contains(decay));
    }
   
}
