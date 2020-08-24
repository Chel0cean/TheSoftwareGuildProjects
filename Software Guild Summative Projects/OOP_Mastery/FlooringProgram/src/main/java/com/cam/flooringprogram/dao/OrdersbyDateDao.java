
package com.cam.flooringprogram.dao;

import com.cam.flooringprogram.dto.Order;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author chelseamiller
 */
public interface OrdersbyDateDao {
    public Order getOrder(int orderNumber,LocalDate date)throws FlooringProgramPersistenceException;
    public List getOrdersbyDate(LocalDate date)throws FlooringProgramPersistenceException;
    public HashMap getAllOrders() throws FlooringProgramPersistenceException;
    public Order createOrder(int orderNumber, Order newOrder)throws FlooringProgramPersistenceException;
    public Order editOrder(Order currentOrdeer)throws FlooringProgramPersistenceException;
    public Order removeOrder(int orderNumber,LocalDate date)throws FlooringProgramPersistenceException;
 
    
}
