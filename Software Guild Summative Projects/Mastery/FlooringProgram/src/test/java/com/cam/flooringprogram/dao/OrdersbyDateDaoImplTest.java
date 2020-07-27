package com.cam.flooringprogram.dao;

import com.cam.flooringprogram.dto.Order;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.cam.flooringprogram.dto.Product;
import java.io.IOException;
import com.cam.flooringprogram.dto.State;
import com.cam.flooringprogram.service.FlooringProgramService;
import com.cam.flooringprogram.service.FlooringProgramServiceImpl;
import java.io.File;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author chelseamiller
 */
public class OrdersbyDateDaoImplTest {

    StateTaxDao stateDao;
    ProductCostDao productDao;
    OrdersbyDateDao testDao;
    FlooringProgramService service;
    BackupDao backupDao;
    AuditDao auditDao;
    Product product;
    State state;
    int orderNumber, secondOrderNumber, thirdOrderNumber;
    Order order, secondOrder, thirdOrder;
    LocalDate date, secondDate;
    String directory;
    
  
    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws IOException, FlooringProgramPersistenceException {

        //productDao = new ProductCostDaoImpl();
         stateDao = new StateTaxDaoImpl("testState.txt");
        //auditDao = new AuditDaoImpl();
        //backupDao = new BackupDaoImpl();
        //service = new FlooringProgramServiceImpl(testDao, stateDao, productDao, backupDao, auditDao);

        //testDao = new OrdersbyDateDaoImpl(directory);
        
          ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("applicationContext.xml");
    testDao =  ctx.getBean("orderDao", OrdersbyDateDao.class);
    //stateDao =  ctx.getBean("stateDao", StateTaxDaoImpl.class);
    productDao =  ctx.getBean("productDao", ProductCostDaoImpl.class);
        
        directory="testOrdersByDate/";
        
        
        File dir = new File(directory);
        dir.mkdir();
        for (File file : dir.listFiles()) {

            file.delete();

        }
        product = productDao.getProduct("fire");
        state = stateDao.getState("dec");
        orderNumber = 1;
        BigDecimal area = new BigDecimal("12");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        LocalDate nonformattedDate = LocalDate.parse("05122021", formatter);
        LocalDate nonformattedDateTwo = LocalDate.parse("06142021", formatter);
        String text = nonformattedDate.format(formatter);
        String textTwo = nonformattedDateTwo.format(formatter);
        date = LocalDate.parse(text, formatter);
        secondDate = LocalDate.parse(textTwo, formatter);
        order = new Order(orderNumber);
        order.setOrderDate(date);
        order.setCustomerName("Twyla");
        order.setArea(area);
        order.setLaborCostPerSqFt(area);
        order.setLaborCostTotal(area);
        order.setMaterialCostPerSqFt(area);
        order.setMaterialCostTotal(area);
        order.setProduct(product);
        order.setState(state);
        order.setTaxRate(area);
        order.setTotalCost(area);
        order.setTaxCostTotal(area);

        secondOrderNumber = 2;
        area = new BigDecimal("40");

        secondOrder = new Order(secondOrderNumber);
        secondOrder.setOrderDate(date);
        secondOrder.setCustomerName("David");
        secondOrder.setArea(area);
        secondOrder.setLaborCostPerSqFt(area);
        secondOrder.setLaborCostTotal(area);
        secondOrder.setMaterialCostPerSqFt(area);
        secondOrder.setMaterialCostTotal(area);
        secondOrder.setProduct(product);
        secondOrder.setState(state);
        secondOrder.setTaxRate(area);
        secondOrder.setTotalCost(area);
        secondOrder.setTaxCostTotal(area);

        thirdOrderNumber = 3;
        area = new BigDecimal("40");

        thirdOrder = new Order(thirdOrderNumber);
        thirdOrder.setOrderDate(secondDate);
        thirdOrder.setCustomerName("Roland");
        thirdOrder.setArea(area);
        thirdOrder.setLaborCostPerSqFt(area);
        thirdOrder.setLaborCostTotal(area);
        thirdOrder.setMaterialCostPerSqFt(area);
        thirdOrder.setMaterialCostTotal(area);
        thirdOrder.setProduct(product);
        thirdOrder.setState(state);
        thirdOrder.setTaxRate(area);
        thirdOrder.setTotalCost(area);
        thirdOrder.setTaxCostTotal(area);
    }

    @AfterEach
    public void tearDown() {

    }

    @Test
    public void testGetOrdersbyDate() throws Exception {

        testDao.createOrder(orderNumber, order);

        testDao.createOrder(secondOrderNumber, secondOrder);

        System.out.println("getOrders");

        List result = testDao.getOrdersbyDate(date);

        assertNotNull(result, "The list of Orders must not be null");
        assertTrue(result.contains(secondOrder));
        assertTrue(result.size() == 2);
    }

    /**
     * Test of createOrder method, of class OrdersbyDateDaoImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCreateGetOrder() throws Exception {
        String directory = "testOrdersByDate/";

        System.out.println("createOrder");

        Order expResult = order;

        Order result = testDao.createOrder(orderNumber, order);
        Order getResult = testDao.getOrder(orderNumber, date);

        assertEquals(expResult, result);

        assertEquals(expResult, getResult);

    }

    /**
     * Test of getAllOrders method, of class OrdersbyDateDaoImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllOrders() throws Exception {

        testDao.createOrder(orderNumber, order);
        testDao.createOrder(secondOrderNumber, secondOrder);
        testDao.createOrder(thirdOrderNumber, thirdOrder);
        System.out.println("getAllOrders");

        HashMap<LocalDate, Map<Integer, Order>> allOrders = testDao.getAllOrders();
        assertTrue(allOrders.size() == 2);

    }

    /**
     * Test of editOrder method, of class OrdersbyDateDaoImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testEditOrder() throws Exception {
        Order editedOrder;
        BigDecimal area = new BigDecimal("40");

        editedOrder = new Order(orderNumber);
        editedOrder.setOrderDate(date);
        editedOrder.setCustomerName("Jessica");
        editedOrder.setArea(area);
        editedOrder.setLaborCostPerSqFt(area);
        editedOrder.setLaborCostTotal(area);
        editedOrder.setMaterialCostPerSqFt(area);
        editedOrder.setMaterialCostTotal(area);
        editedOrder.setProduct(product);
        editedOrder.setState(state);
        editedOrder.setTaxRate(area);
        editedOrder.setTotalCost(area);
        editedOrder.setTaxCostTotal(area);

        System.out.println("editOrder");
        testDao.createOrder(orderNumber, order);
        Order currentOrder = order;
        testDao.editOrder(editedOrder);
        Order thisOrder = testDao.getOrder(orderNumber, date);
        assertTrue(thisOrder.getCustomerName().contains("Jessica"));

    }

    /**
     * Test of removeOrder method, of class OrdersbyDateDaoImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testRemoveOrder() throws Exception {

        System.out.println("removeOrder");

        testDao.createOrder(orderNumber, order);
        testDao.removeOrder(orderNumber, date);

        assertNull(testDao.getOrder(orderNumber, date));

    }

}
