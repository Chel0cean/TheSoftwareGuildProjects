package com.cam.flooringprogram.service;

import com.cam.flooringprogram.dao.FlooringProgramPersistenceException;
import com.cam.flooringprogram.dao.OrdersbyDateDao;
import com.cam.flooringprogram.dto.Order;
import com.cam.flooringprogram.dto.Product;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author chelseamiller
 */
public class OrderDaoStubImpl implements OrdersbyDateDao {

    public Order onlyOrder;
    ProductDaoStubImpl product= new ProductDaoStubImpl();
    StateDaoStubImpl state = new StateDaoStubImpl();
    int orderNumber;
    LocalDate date;

    public OrderDaoStubImpl() throws FlooringProgramPersistenceException {
        
        
        orderNumber = 1;
        BigDecimal area = new BigDecimal("12");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        LocalDate nonformattedDate = LocalDate.parse("05122021", formatter);

        String text = nonformattedDate.format(formatter);

        date = LocalDate.parse(text, formatter);

        onlyOrder = new Order(orderNumber);
        onlyOrder.setOrderDate(date);
        onlyOrder.setCustomerName("Twyla");
        onlyOrder.setArea(area);
        onlyOrder.setLaborCostPerSqFt(area);
        onlyOrder.setLaborCostTotal(area);
        onlyOrder.setMaterialCostPerSqFt(area);
        onlyOrder.setMaterialCostTotal(area);
        onlyOrder.setProduct(product.getProduct("Splinters"));
        onlyOrder.setState(state.getState("HI"));
        onlyOrder.setTaxRate(area);
        onlyOrder.setTotalCost(area);
        onlyOrder.setTaxCostTotal(area);

    }

    public OrderDaoStubImpl(Order testOrder) {
        this.onlyOrder = testOrder;
    }

    @Override
    public Order getOrder(int orderNumber, LocalDate date) throws FlooringProgramPersistenceException {
        if (orderNumber == onlyOrder.getOrderNumber()) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public List getOrdersbyDate(LocalDate date) throws FlooringProgramPersistenceException {
        HashMap<LocalDate, Map<Integer, Order>> outer = new HashMap<>();
        HashMap<Integer, Order> inner = new HashMap<>();
        inner.put(onlyOrder.getOrderNumber(), onlyOrder);
        outer.put(onlyOrder.getOrderDate(), inner);
        List<Map<Integer, Order>> ordersByDate= new ArrayList<>();
       
        ordersByDate =  outer.values().stream().collect(Collectors.toList());

        return ordersByDate;
    }

    @Override
    public HashMap getAllOrders() throws FlooringProgramPersistenceException {
        HashMap<LocalDate, Map<Integer, Order>> outer = new HashMap<>();
        HashMap<Integer, Order> inner = new HashMap<>();
        inner.put(orderNumber, onlyOrder);
        outer.put(date, inner);

        return outer;
    }

    @Override
    public Order createOrder(int orderNumber, Order newOrder) throws FlooringProgramPersistenceException {
        if (orderNumber == onlyOrder.getOrderNumber()) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public Order editOrder(Order currentOrder) throws FlooringProgramPersistenceException {
        
        onlyOrder = currentOrder;
        return onlyOrder;
    }

    @Override
    public Order removeOrder(int orderNumber, LocalDate date) throws FlooringProgramPersistenceException {
        if (orderNumber == onlyOrder.getOrderNumber()) {
            return onlyOrder;
        } else {
            return null;
        }
    }
}
