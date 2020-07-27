package com.cam.flooringprogram.service;

import com.cam.flooringprogram.dao.AuditDao;
import com.cam.flooringprogram.dao.BackupDao;
import com.cam.flooringprogram.dao.OrdersbyDateDao;
import com.cam.flooringprogram.dao.ProductCostDao;
import com.cam.flooringprogram.dao.StateTaxDao;
import com.cam.flooringprogram.dto.Order;
import java.time.LocalDate;
import java.util.List;
import com.cam.flooringprogram.dao.FlooringProgramPersistenceException;
import com.cam.flooringprogram.dto.Product;
import com.cam.flooringprogram.dto.State;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author chelseamiller
 */
public class FlooringProgramServiceImpl implements FlooringProgramService {

    OrdersbyDateDao orderDao;
    StateTaxDao stateDao;
    ProductCostDao productDao;
    BackupDao backupDao;
    AuditDao auditDao;

    public FlooringProgramServiceImpl(OrdersbyDateDao orderDao, StateTaxDao stateDao, ProductCostDao productDao, BackupDao backupDao, AuditDao auditDao) {
        this.orderDao = orderDao;
        this.stateDao = stateDao;
        this.productDao = productDao;
        this.backupDao = backupDao;
        this.auditDao = auditDao;
    }

 
    @Override
    public void createOrder(Order newOrder) throws FlooringProgramPersistenceException {

        orderDao.createOrder(0, newOrder);
    }

    @Override
    public void editOrder(Order currentOrder) throws FlooringProgramPersistenceException {

        orderDao.editOrder(currentOrder);
    }

    @Override
    public int removeOrder(int orderNumber, LocalDate orderDate) throws FlooringProgramPersistenceException {

        Order deletedOrder = orderDao.removeOrder(orderNumber, orderDate);
        return deletedOrder.getOrderNumber();
    }

    @Override
    public boolean exportData() throws FlooringProgramPersistenceException {
        HashMap allOrders =orderDao.getAllOrders();
        if (!allOrders.isEmpty()){
        backupDao.WriteBackupEntry(orderDao.getAllOrders());
        return true;
        }
        else{
           return false; 
        }
    }

    @Override
    public Order getOrder(int orderNumber, LocalDate orderDate) throws FlooringProgramPersistenceException {
        Order order = orderDao.getOrder(orderNumber, orderDate);
        return order;
    }

    @Override
    public List getOrders(LocalDate orderDate) throws FlooringProgramPersistenceException {

        List<Order> allOrders = orderDao.getOrdersbyDate(orderDate);
        return allOrders;
    }

    @Override
    public int getOrderNumber() throws FlooringProgramPersistenceException {
        int orderNumber = 0;
        List<Integer> allOrderNumbers;
        HashMap<LocalDate, Map<Integer, Order>> allOrders = orderDao.getAllOrders();

        List<LocalDate> allLocalDates = new ArrayList(allOrders.keySet());

        for (LocalDate date : allLocalDates) {
            Map<Integer, Order> ordersFromDate = allOrders.get(date);
            allOrderNumbers = new ArrayList(ordersFromDate.keySet());

            for (int i : allOrderNumbers) {
                if (i > orderNumber) {
                    orderNumber = i;
                }
            }
        }

        return (orderNumber + 1);

    }

    @Override
    public BigDecimal calculateMaterialCostTotal(Order currentOrder) {
        BigDecimal costSqFt = currentOrder.getMaterialCostPerSqFt();
        BigDecimal area = currentOrder.getArea();

        return area.multiply(costSqFt).setScale(2, RoundingMode.UP);
    }

    @Override
    public BigDecimal calculateLaborCostTotal(Order currentOrder) {
        BigDecimal costSqFt = currentOrder.getLaborCostPerSqFt();
        BigDecimal area = currentOrder.getArea();

        return area.multiply(costSqFt).setScale(2, RoundingMode.UP);
    }

    @Override
    public BigDecimal calculateTaxCostTotal(Order currentOrder) {
        BigDecimal taxRate = currentOrder.getTaxRate();
        BigDecimal taxAsPercentage = taxRate.divide(new BigDecimal("100"));
        BigDecimal totalBeforeTax = currentOrder.getMaterialCostTotal().add(currentOrder.getLaborCostTotal());
        return totalBeforeTax.multiply(taxAsPercentage).setScale(2, RoundingMode.UP);

    }

    @Override
    public BigDecimal calculateTotalCost(Order currentOrder) {
        return currentOrder.getMaterialCostTotal().add(currentOrder.getLaborCostTotal()).add(currentOrder.getTaxCostTotal()).setScale(2, RoundingMode.UP);

    }

    @Override
    public State createState(String abbreviation, State state) throws FlooringProgramPersistenceException {
       return stateDao.createState(abbreviation, state);
        
    }

    @Override
    public State editState(String abbreviation, State state) throws FlooringProgramPersistenceException {
        return stateDao.editState(abbreviation, state);
    }

    @Override
    public State deleteState(String abbreviation) throws FlooringProgramPersistenceException {
        return stateDao.removeState(abbreviation);
    }

    @Override
    public Product createProduct(String materialType, Product newProduct) throws FlooringProgramPersistenceException {
        return productDao.createProduct(materialType, newProduct);
    }

    @Override
    public Product editProduct(String materialType, Product newProduct) throws FlooringProgramPersistenceException {
        return productDao.editProduct(materialType, newProduct);
    }

    @Override
    public Product deleteProduct(String materialType) throws FlooringProgramPersistenceException {
       return productDao.removeProduct(materialType);
    }

    @Override
    public State getState(String abbreviation) throws FlooringProgramPersistenceException {
        State thisState = stateDao.getState(abbreviation);
        return thisState;
    }

    @Override
    public List getStates() throws FlooringProgramPersistenceException {

        List<State> allStates = stateDao.getAllStates();
        return allStates;
    }

    @Override
    public List getStateAbbreviationList() throws FlooringProgramPersistenceException {
        List<State> allStates = stateDao.getAllStates();
        List<String> stateAbbreviations = new ArrayList();
        allStates.stream().map((currentState) -> currentState.getAbbreviation()).forEachOrdered((stateAbb) -> {
            stateAbbreviations.add(stateAbb);
        });
        return stateAbbreviations;
    }

    @Override
    public Product getProduct(String productType) throws FlooringProgramPersistenceException {
        Product thisProduct = productDao.getProduct(productType);
        return thisProduct;
    }

    @Override
    public List getProducts() throws FlooringProgramPersistenceException {

        List<Product> allProducts = productDao.getAllProducts();
        return allProducts;
    }

    @Override
    public boolean validateCustomerName(String newCustomerName) throws FlooringProgramUserValidationException {
        boolean valid;
        
        String Regex = "^[a-zA-Z0-9.,\\s]*$";
        newCustomerName.split(Regex);
        Pattern acceptedChar = Pattern.compile(Regex);
        Matcher matched = acceptedChar.matcher(newCustomerName);

        if (matched.matches()) {
            valid = true;

        } else {
            valid = false;
        }
        return valid;

    }

    @Override
    public void loadAssistingCollections() throws FlooringProgramPersistenceException {
        stateDao.loadCollection();
        productDao.getAllProducts();
    }

}
