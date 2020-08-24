
package com.cam.flooringprogram.dao;

import com.cam.flooringprogram.dto.Product;
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
public class ProductCostDaoImplTest {
    ProductCostDao testDao;
    String materialType, materialTypeTwo;
    Product glass, fire;
    public ProductCostDaoImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws IOException {
        String testFile = "testProduct.txt";
        // Use the FileWriter to quickly blank the file
        new FileWriter(testFile);
        
        
         ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("applicationContext.xml");
    testDao = 
        ctx.getBean("productDao", ProductCostDao.class);
        
        materialTypeTwo="fire";
        fire = new Product(materialTypeTwo);
        fire.setLaborCostSqFt(new BigDecimal("5.00"));
        fire.setMaterialCostSqFt(new BigDecimal("4.00"));
        
       materialType="shardsOfGlass";
        BigDecimal auto = new BigDecimal("3");
        glass = new Product(materialType);
        glass.setLaborCostSqFt(auto);
        glass.setMaterialCostSqFt(auto);
     
    }
    
    @AfterEach
    public void tearDown() {
    }

  
    /**
     * Test of editProduct method, of class ProductCostDaoImpl.
     * @throws java.lang.Exception
     */
    @Test
    public void testEditProduct() throws Exception {
        System.out.println("editProduct");
      
       testDao.createProduct(materialType, glass);
       
       BigDecimal oldPrice= glass.getLaborCostSqFt();
       
        BigDecimal updatedPrice = new BigDecimal("4");
    
        glass.setLaborCostSqFt(updatedPrice);
       
        
        
        testDao.editProduct(materialType, glass);
        
       BigDecimal currentPrice = glass.getLaborCostSqFt();
        
       
        assertNotEquals(oldPrice, currentPrice);
    
    }

    /**
     * Test of removeProduct method, of class ProductCostDaoImpl.
     * @throws java.lang.Exception
     */
    @Test
    public void testRemoveProduct() throws Exception {
        System.out.println("removeProduct");
        testDao.createProduct(materialType, glass);
        testDao.createProduct(materialTypeTwo, fire);
        List<Product> firstResult =testDao.getAllProducts();
        testDao.removeProduct(materialType);
       List<Product> secondResult =testDao.getAllProducts();
       
        assertNotEquals(firstResult, secondResult);
    
    }

    /**
     * Test of getProduct method, of class ProductCostDaoImpl.
     * @throws java.lang.Exception
   */
    @Test
    public void testAddGetProduct() throws Exception {
        System.out.println("createProduct");
 
        testDao.createProduct(materialType, glass);
        
        System.out.println("getProduct");
        Product expResult = glass;
        Product result = testDao.getProduct(materialType);
        assertEquals(expResult, result);

    }

    /**
     * Test of getAllProducts method, of class ProductCostDaoImpl.
     */
    @Test
    public void testGetAllProducts() throws Exception {
        System.out.println("getAllProducts");
       testDao.createProduct(materialType, glass);
       testDao.createProduct(materialTypeTwo, fire);
        
        
        List<Product> result = testDao.getAllProducts();
        assertTrue(result.contains(glass));
         assertTrue(result.contains(fire));
        
    }
   
}
