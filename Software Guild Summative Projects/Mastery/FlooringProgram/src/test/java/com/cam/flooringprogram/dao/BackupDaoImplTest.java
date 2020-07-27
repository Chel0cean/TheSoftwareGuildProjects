/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cam.flooringprogram.dao;

import com.cam.flooringprogram.dto.Order;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author chelseamiller
 */
public class BackupDaoImplTest {

    BackupDao testDao;
    OrdersbyDateDaoImpl orderDao;

    
    public BackupDaoImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
         ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("applicationContext.xml");
    testDao = 
        ctx.getBean("backupDao", BackupDao.class);
  
    orderDao = 
        ctx.getBean("orderDao", OrdersbyDateDaoImpl.class);
    }
    
    @AfterEach
    public void tearDown() {
    }

    

    /**
     * Test of WriteBackupEntry method, of class BackupDaoImpl.
     * @throws java.lang.Exception
    */
    @Test
    public void testWriteBackupEntry() throws Exception {
      
       
        System.out.println("WriteBackupEntry");
        
        HashMap<LocalDate, Map<Integer, Order>> allOrders = orderDao.getAllOrders();
       
        testDao.WriteBackupEntry(allOrders);
     
    }

}
