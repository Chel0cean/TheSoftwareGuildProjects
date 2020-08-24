package com.cam.flooringprogram.service;

import com.cam.flooringprogram.dao.FlooringProgramPersistenceException;
import com.cam.flooringprogram.dao.ProductCostDao;
import com.cam.flooringprogram.dao.StateTaxDao;
import com.cam.flooringprogram.dto.Order;
import com.cam.flooringprogram.dto.Product;
import com.cam.flooringprogram.dto.State;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author chelseamiller
 */
public interface FlooringProgramService {



    public void createOrder(Order newOrder)throws FlooringProgramPersistenceException;

    public void editOrder(Order currentOrder)throws FlooringProgramPersistenceException;

    public int removeOrder(int orderNumber, LocalDate orderDate)throws FlooringProgramPersistenceException;

    public boolean exportData()throws FlooringProgramPersistenceException;

    public Order getOrder(int orderNumber, LocalDate orderDate)throws FlooringProgramPersistenceException;

    public List getOrders(LocalDate orderDate)throws FlooringProgramPersistenceException;

    public int getOrderNumber()throws FlooringProgramPersistenceException;

    public BigDecimal calculateMaterialCostTotal(Order currentOrder);

    public BigDecimal calculateLaborCostTotal(Order currentOrder);

    public BigDecimal calculateTaxCostTotal(Order currentOrder);

    public BigDecimal calculateTotalCost(Order currentOrder);


    public State createState(String abbreviation, State state)throws FlooringProgramPersistenceException;

    public State editState(String abbreviation, State state)throws FlooringProgramPersistenceException;

    public State deleteState(String abbreviation)throws FlooringProgramPersistenceException;

    public Product createProduct(String materialType, Product newProduct)throws FlooringProgramPersistenceException;

    public Product editProduct(String materialType, Product newProduct)throws FlooringProgramPersistenceException;

    public Product deleteProduct(String materialType)throws FlooringProgramPersistenceException;

    public State getState(String abbreviation)throws FlooringProgramPersistenceException;
    public List getStates() throws FlooringProgramPersistenceException; 

    public List getStateAbbreviationList()throws FlooringProgramPersistenceException;

    public Product getProduct(String productType)throws FlooringProgramPersistenceException;
    
    public List getProducts() throws FlooringProgramPersistenceException; 

 

    public boolean validateCustomerName(String newCustomerName)throws FlooringProgramUserValidationException;
    
     public void loadAssistingCollections() throws FlooringProgramPersistenceException;

}
