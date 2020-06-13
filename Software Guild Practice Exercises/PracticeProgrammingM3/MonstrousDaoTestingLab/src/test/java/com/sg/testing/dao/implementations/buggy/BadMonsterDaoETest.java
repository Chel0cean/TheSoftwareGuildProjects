/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.testing.dao.implementations.buggy;

import com.sg.testing.dao.implementations.AGoodMonsterDao;
import com.sg.testing.model.Monster;
import static com.sg.testing.model.MonsterType.LIZARDMAN;
import static com.sg.testing.model.MonsterType.YETI;
import java.util.List;
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
public class BadMonsterDaoETest {
    
    public BadMonsterDaoETest() {
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
     * Test of addMonster method, of class BadMonsterDaoE.
     */
    

    /**
     * Test of getMonster method, of class BadMonsterDaoE.
     */
  @Test
    public void testAddGetMonster() {
        AGoodMonsterDao gM = new AGoodMonsterDao();
        System.out.println("addMonster");
        int id = 1;
        Monster m = new Monster();
        m.setName("Frank");
        m.setType(YETI);
        m.setFavoriteFood("human");
        m.setPeopleEaten(2);
        gM.addMonster(1, m); 
        Monster expResult = m;
        Monster result = gM.getMonster(id);
        assertEquals(expResult, result);
    }
    
   @Test
    public void testGetAllMonsters() {
        AGoodMonsterDao gM = new AGoodMonsterDao();
        System.out.println("getAllMonsters");
        int id = 1;
        Monster m = new Monster();
        m.setName("Frank");
        m.setType(YETI);
        m.setFavoriteFood("human");
        m.setPeopleEaten(2);
        gM.addMonster(id, m);
        
        int id2 = 2;
        Monster n = new Monster();
        n.setName("Petunia");
        n.setType(LIZARDMAN);
        n.setFavoriteFood("Flies");
        n.setPeopleEaten(17);
        gM.addMonster(id2, n);
        
        List<Monster> allMonsters = gM.getAllMonsters();
        
        assertNotNull(allMonsters, "The list of monsters must not be null");
        assertEquals(2, allMonsters.size(), "List of monsters should have 2 monsters.");
        
        assertTrue(gM.getAllMonsters().contains(m),
                "The list of Monsters should include m.");
        assertTrue(gM.getAllMonsters().contains(n),
                "The list of Monsters should include n.");
    }

    /**
     * Test of updateMonster method, of class AGoodMonsterDao.
     */
    @Test
    public void testUpdateMonster() {
        System.out.println("updateMonster");
          AGoodMonsterDao gM = new AGoodMonsterDao();
        System.out.println("getAllMonsters");
        Monster m = new Monster();
        m.setName("Frank");
        m.setType(YETI);
        m.setFavoriteFood("human");
        m.setPeopleEaten(2);
        gM.addMonster(1, m);
        
        Monster expResult = m;
        Monster result = gM.getMonster(1);
        assertEquals(expResult, result, "the 1st monster was successfully stored");
        
        //create second monster
        Monster n = new Monster();
        n.setName("Petunia");
        n.setType(LIZARDMAN);
        n.setFavoriteFood("Flies");
        n.setPeopleEaten(17);
        
        
        gM.updateMonster(1, n);
        Monster result2 = gM.getMonster(1);
        
        assertEquals(n, result2, "the 1st monster was successfully updated to n");
        
        
    }

    /**
     * Test of removeMonster method, of class AGoodMonsterDao.
     */
    @Test
    public void testRemoveMonster() {
        System.out.println("removeMonster");
         AGoodMonsterDao gM = new AGoodMonsterDao();
        int id = 1;
        Monster m = new Monster();
        m.setName("Frank");
        m.setType(YETI);
        m.setFavoriteFood("human");
        m.setPeopleEaten(2);
        gM.addMonster(id, m);
        
        int id2 = 2;
        Monster n = new Monster();
        n.setName("Petunia");
        n.setType(LIZARDMAN);
        n.setFavoriteFood("Flies");
        n.setPeopleEaten(17);
        gM.addMonster(id2, n);
        
        Monster removedMonster = gM.removeMonster(1);
        assertEquals(removedMonster, m, "The removed monster should be m.");
        
        List<Monster> allMonsters = gM.getAllMonsters();
        
         assertNotNull(allMonsters, "The list of monsters must not be null");
        assertEquals(1, allMonsters.size(), "List of monsters should have 1 monster.");
        
        assertFalse(gM.getAllMonsters().contains(m),
                "The list of Monsters should not include m.");
        assertTrue(gM.getAllMonsters().contains(n),
                "The list of Monsters should include n.");
        
        Monster removedMonster2 = gM.removeMonster(2);
        assertEquals(removedMonster2, n, "The removed monster should be n.");
        
        allMonsters = gM.getAllMonsters();
        
        assertTrue(allMonsters.isEmpty(), "The retrieved list of Monsters should be empty.");
       
        Monster retrievedMonster = gM.getMonster(1);
        assertNull(retrievedMonster, "m was removed, should be null.");

        retrievedMonster = gM.getMonster(2);
        assertNull(retrievedMonster, "n was removed, should be null.");

    }
    
}
