package com.cam.vendingmachine.service;

import com.cam.vendingmachine.dao.VendingMachineDao;
import com.cam.vendingmachine.dao.VendingMachinePersistenceException;
import com.cam.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chelseamiller
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao {

    public Item onlyItem;

    public VendingMachineDaoStubImpl() {
        onlyItem = new Item("Cupcakes");
        onlyItem.setInventoryCount(10);
        onlyItem.setCost(new BigDecimal("4.00"));

    }

    public VendingMachineDaoStubImpl(Item testItem) {
        this.onlyItem = testItem;
    }

    @Override
    public Item addItem(String name, Item item) throws VendingMachinePersistenceException {
       if (name.equals(onlyItem.getName())) {
            return onlyItem;
        } else {
            return null;
        }
    }
    
    @Override
    public void editItem(String name, Item item) throws VendingMachinePersistenceException {
     onlyItem.setName(name);
     onlyItem = item;
     
    }

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
       List<Item> itemList = new ArrayList<>();
        itemList.add(onlyItem);
        return itemList;
    }

    @Override
    public Item getItem(String name) throws VendingMachinePersistenceException {
        if (name.equals(onlyItem.getName())) {
            return onlyItem;
        } else {
            return null;
        }  
    }

    @Override
    public Item removeItem(String name) throws VendingMachinePersistenceException {
         if (name.equals(onlyItem.getName())) {
            return onlyItem;
        } else {
            return null;
        }
    }  

    
    }

    


