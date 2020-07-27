package com.cam.flooringprogram.service;

import com.cam.flooringprogram.dao.AuditDao;
import com.cam.flooringprogram.dao.BackupDao;
import com.cam.flooringprogram.dao.FlooringProgramPersistenceException;
import com.cam.flooringprogram.dao.OrdersbyDateDao;
import com.cam.flooringprogram.dao.ProductCostDao;
import com.cam.flooringprogram.dao.StateTaxDao;
import com.cam.flooringprogram.dto.Order;
import com.cam.flooringprogram.dto.Product;
import com.cam.flooringprogram.dto.State;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class FlooringProgramServiceImplTest {

    OrderDaoStubImpl orderDao;
    ProductDaoStubImpl productDao;
    StateDaoStubImpl stateDao;
    BackupDaoStubImpl backupDao;
    AuditDaoStubImpl auditDao;
    FlooringProgramService testService;

    Product onlyProduct;
    State onlyState;
    Order onlyOrder;

    public FlooringProgramServiceImplTest() {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        testService = ctx.getBean("serviceLayer", FlooringProgramService.class);
    }

    @BeforeAll
    public static void setUpClass() throws FlooringProgramPersistenceException {

    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() throws FlooringProgramPersistenceException {

        String materialType = "Splinters";
        onlyProduct = new Product(materialType);
        onlyProduct.setLaborCostSqFt(new BigDecimal("10"));
        onlyProduct.setMaterialCostSqFt(new BigDecimal("4.00"));
        //productDao.createProduct(materialType, onlyProduct);

        String abbr = "HI";
        onlyState = new State(abbr);

        onlyState.setName("Hawaii");
        onlyState.setTaxRate(new BigDecimal("4"));
        //stateDao.createState(abbr, onlyState);

        int orderNumber = 1;
        BigDecimal area = new BigDecimal("12");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        LocalDate nonformattedDate = LocalDate.parse("05122021", formatter);

        String text = nonformattedDate.format(formatter);

        LocalDate date = LocalDate.parse(text, formatter);

        onlyOrder = new Order(orderNumber);
        onlyOrder.setOrderDate(date);
        onlyOrder.setCustomerName("Topanga");
        onlyOrder.setArea(area);
        onlyOrder.setLaborCostPerSqFt(area);
        onlyOrder.setLaborCostTotal(area);
        onlyOrder.setMaterialCostPerSqFt(area);
        onlyOrder.setMaterialCostTotal(area);
        onlyOrder.setProduct(onlyProduct);
        onlyOrder.setState(onlyState);
        onlyOrder.setTaxRate(area);
        onlyOrder.setTotalCost(area);
        onlyOrder.setTaxCostTotal(area);

    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetOrderNumber() throws Exception {
        System.out.println("getOrderNumber");

        int result = testService.getOrderNumber();
        int expResult = 2;

        assertEquals(expResult, result);

    }

    /**
     * Test of calculateMaterialCostTotal method, of class
     * FlooringProgramServiceImpl.
     *
     *
     */
    @Test
    public void testCalculateMaterialCostTotal() {
        System.out.println("calculateMaterialCostTotal");
        BigDecimal costSqFt = onlyOrder.getMaterialCostPerSqFt();
        BigDecimal area = onlyOrder.getArea();

        BigDecimal expResult = area.multiply(costSqFt).setScale(2, RoundingMode.UP);
        BigDecimal result = testService.calculateMaterialCostTotal(onlyOrder);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateLaborCostTotal method, of class
     * FlooringProgramServiceImpl.
     *
     */
    @Test
    public void testCalculateLaborCostTotal() {
        System.out.println("calculateLaborCostTotal");

        BigDecimal costSqFt = onlyOrder.getLaborCostPerSqFt();
        BigDecimal area = onlyOrder.getArea();

        BigDecimal expResult = area.multiply(costSqFt).setScale(2, RoundingMode.UP);

        BigDecimal result = testService.calculateLaborCostTotal(onlyOrder);
        assertEquals(expResult, result);

    }

    /**
     * Test of calculateTaxCostTotal method, of class
     * FlooringProgramServiceImpl.
     *
     */
    @Test
    public void testCalculateTaxCostTotal() {
        System.out.println("calculateTaxCostTotal");
        BigDecimal taxRate = onlyOrder.getTaxRate();
        BigDecimal taxAsPercentage = taxRate.divide(new BigDecimal("100"));
        BigDecimal totalBeforeTax = onlyOrder.getMaterialCostTotal().add(onlyOrder.getLaborCostTotal());

        BigDecimal expResult = totalBeforeTax.multiply(taxAsPercentage).setScale(2, RoundingMode.UP);
        BigDecimal result = testService.calculateTaxCostTotal(onlyOrder);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateTotalCost method, of class FlooringProgramServiceImpl.
     */
    @Test
    public void testCalculateTotalCost() {
        System.out.println("calculateTotalCost");

        BigDecimal result = testService.calculateTotalCost(onlyOrder);

        Order currentOrder = onlyOrder;

        BigDecimal expResult = currentOrder.getMaterialCostTotal().add(currentOrder.getLaborCostTotal()).add(currentOrder.getTaxCostTotal()).setScale(2, RoundingMode.UP);

        assertEquals(expResult, result);

    }

    @Test
    public void testGetStateAbbreviationList() throws Exception {

        System.out.println("getStateAbbreviationList");
        stateDao = new StateDaoStubImpl(onlyOrder.getState());
        testService = new FlooringProgramServiceImpl(orderDao, stateDao, productDao, backupDao, auditDao);

        String stateAbbr = onlyOrder.getState().getAbbreviation();

        List result = testService.getStateAbbreviationList();
        assertTrue(result.contains(stateAbbr));

    }

    /**
     * Test of validateCustomerName method, of class FlooringProgramServiceImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testValidateCustomerName() throws Exception {
        System.out.println("validateCustomerName");
        String validCustomerName = "123abc ,.XYZ ";
        String invalidCustomerName = "!@#$%^&*";
        assertFalse(testService.validateCustomerName(invalidCustomerName));
        assertTrue(testService.validateCustomerName(validCustomerName));

    }

    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~CRUD ORDER/STATE/PRODUCT TEST FUNCTIONS~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    @Test
    public void testCreateGetOrder() throws Exception {

        System.out.println("createOrder");

        orderDao = new OrderDaoStubImpl(onlyOrder);
        testService = new FlooringProgramServiceImpl(orderDao, stateDao, productDao, backupDao, auditDao);

        testService.createOrder(onlyOrder);

        System.out.println("getOrder");

        Order result = testService.getOrder(onlyOrder.getOrderNumber(),
                onlyOrder.getOrderDate());
        assertEquals(onlyOrder, result);

    }

    /**
     * Test of editOrders method, of class FlooringProgramServiceImpl.
     *
     * @throws com.cam.flooringprogram.dao.FlooringProgramPersistenceException
     */
    @Test
    public void testEditOrder() throws FlooringProgramPersistenceException {

        String oldCustomerName = onlyOrder.getCustomerName();
        String newCustomerName = "Sebastian";
        onlyOrder.setCustomerName(newCustomerName);
        orderDao = new OrderDaoStubImpl(onlyOrder);
        testService = new FlooringProgramServiceImpl(orderDao, stateDao, productDao, backupDao, auditDao);
        testService.editOrder(onlyOrder);
        String result = onlyOrder.getCustomerName();
        assertEquals(newCustomerName, result);
        assertNotEquals(oldCustomerName, result);
    }

    @Test
    public int testRemoveOrder(int orderNumber, LocalDate orderDate) throws FlooringProgramPersistenceException {
        orderDao = new OrderDaoStubImpl(onlyOrder);
        testService = new FlooringProgramServiceImpl(orderDao, stateDao, productDao, backupDao, auditDao);
        int removedOrderNumber = testService.removeOrder(orderNumber, orderDate);

        try {
            testService.getOrder(orderNumber, orderDate);
            fail("Expected ValidationException was not thrown.");
        } catch (NullPointerException e) {

        }
        return removedOrderNumber;
    }

    /**
     * Test of getOrders method, of class FlooringProgramServiceImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetOrders() throws Exception {
        System.out.println("getOrders");
        orderDao = new OrderDaoStubImpl(onlyOrder);
        testService = new FlooringProgramServiceImpl(orderDao, stateDao, productDao, backupDao, auditDao);

        List<Order> allOrdersFromDate = testService.getOrders(onlyOrder.getOrderDate());
        assertTrue(allOrdersFromDate.size() == 1);

    }

    /**
     * Test of createState method, of class FlooringProgramServiceImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCreateGetState() throws Exception {
        System.out.println("createState");
        String abbreviation = "NC";

        State state = new State(abbreviation);
        state.setName("North Carolina");
        state.setTaxRate(new BigDecimal("2"));

        stateDao = new StateDaoStubImpl(state);
        testService = new FlooringProgramServiceImpl(orderDao, stateDao, productDao, backupDao, auditDao);

        testService.createState(abbreviation, state);
        State result = testService.getState(abbreviation);
        assertEquals(result, state);
    }

    /**
     * Test of editState method, of class FlooringProgramServiceImpl.
     */
    @Test
    public void testEditState() throws Exception {
        System.out.println("editState");

        String abbreviation = "NC";

        State state = new State(abbreviation);
        state.setName("North Carolina");
        state.setTaxRate(new BigDecimal("2"));

        stateDao = new StateDaoStubImpl(state);
        testService = new FlooringProgramServiceImpl(orderDao, stateDao, productDao, backupDao, auditDao);

        BigDecimal oldTaxRate = state.getTaxRate();
        state.setTaxRate(new BigDecimal("4"));
        testService.editState(abbreviation, state);
        BigDecimal currentTaxRate = state.getTaxRate();
        assertNotEquals(currentTaxRate, oldTaxRate);
    }

    /**
     * Test of deleteState method, of class FlooringProgramServiceImpl.
     */
    @Test
    public void testDeleteState() throws Exception {
        System.out.println("deleteState");

        String abbreviation = "NC";

        State state = new State(abbreviation);
        state.setName("North Carolina");
        state.setTaxRate(new BigDecimal("2"));

        stateDao = new StateDaoStubImpl(state);
        testService = new FlooringProgramServiceImpl(orderDao, stateDao, productDao, backupDao, auditDao);

        State deletedState = testService.deleteState(abbreviation);

        assertEquals(deletedState, state);
    }

    /**
     * Test of createProduct method, of class FlooringProgramServiceImpl.
     */
    @Test
    public void testCreateGetProduct() throws Exception {
        System.out.println("createProduct");

        String materialType = "Rusty Nails";

        Product product = new Product(materialType);
        product.setLaborCostSqFt(new BigDecimal("4"));
        product.setMaterialCostSqFt(new BigDecimal("4"));

        productDao = new ProductDaoStubImpl(product);
        testService = new FlooringProgramServiceImpl(orderDao, stateDao, productDao, backupDao, auditDao);

        testService.createProduct(materialType, product);
        Product result = testService.getProduct(materialType);
        assertEquals(result, product);
    }

    /**
     * Test of editProduct method, of class FlooringProgramServiceImpl.
     */
    @Test
    public void testEditProduct() throws Exception {
        System.out.println("editProduct");

        String materialType = "Rusty Nails";

        Product product = new Product(materialType);
        product.setLaborCostSqFt(new BigDecimal("4"));
        product.setMaterialCostSqFt(new BigDecimal("4"));

        productDao = new ProductDaoStubImpl(product);
        testService = new FlooringProgramServiceImpl(orderDao, stateDao, productDao, backupDao, auditDao);

        BigDecimal oldLaborCost = product.getLaborCostSqFt();
        product.setLaborCostSqFt(new BigDecimal("12"));
        testService.editProduct(materialType, product);
        BigDecimal currentLaborCost = product.getLaborCostSqFt();
        assertNotEquals(currentLaborCost, oldLaborCost);
    }

    /**
     * Test of deleteProduct method, of class FlooringProgramServiceImpl.
     */
    @Test
    public void testDeleteProduct() throws Exception {
        System.out.println("deleteProduct");

        String materialType = "Rusty Nails";

        Product product = new Product(materialType);
        product.setLaborCostSqFt(new BigDecimal("4"));
        product.setMaterialCostSqFt(new BigDecimal("4"));

        productDao = new ProductDaoStubImpl(product);
        testService = new FlooringProgramServiceImpl(orderDao, stateDao, productDao, backupDao, auditDao);

        Product deletedProduct = testService.deleteProduct(materialType);

        assertEquals(deletedProduct, product);
    }

    /**
     * Test of getStates method, of class FlooringProgramServiceImpl.
     */
    @Test
    public void testGetStates() throws Exception {
        System.out.println("getStates");

        String abbreviation = "NC";

        State state = new State(abbreviation);
        state.setName("North Carolina");
        state.setTaxRate(new BigDecimal("2"));

        stateDao = new StateDaoStubImpl(state);
        testService = new FlooringProgramServiceImpl(orderDao, stateDao, productDao, backupDao, auditDao);

        List result = testService.getStates();
        assertTrue(result.contains(state));

    }

    /**
     * Test of getStateAbbreviationList method, of class
     * FlooringProgramServiceImpl.
     */
    /**
     * Test of getProducts method, of class FlooringProgramServiceImpl.
     */
    @Test
    public void testGetProducts() throws Exception {
        System.out.println("getProducts");

        String materialType = "Rusty Nails";

        Product product = new Product(materialType);
        product.setLaborCostSqFt(new BigDecimal("4"));
        product.setMaterialCostSqFt(new BigDecimal("4"));

        productDao = new ProductDaoStubImpl(product);
        testService = new FlooringProgramServiceImpl(orderDao, stateDao, productDao, backupDao, auditDao);

        List result = testService.getProducts();
        assertTrue(result.contains(product));

    }

}
