package com.cam.vendingmachine.service;

import com.cam.vendingmachine.dao.VendingMachineAuditDao;
import com.cam.vendingmachine.dao.VendingMachineDao;
import com.cam.vendingmachine.dao.VendingMachinePersistenceException;
import com.cam.vendingmachine.dto.Change;
import com.cam.vendingmachine.dto.coins;
import static com.cam.vendingmachine.dto.coins.DIME;
import static com.cam.vendingmachine.dto.coins.NICKEL;
import static com.cam.vendingmachine.dto.coins.PENNY;
import static com.cam.vendingmachine.dto.coins.QUARTER;
import com.cam.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author chelseamiller
 */
public class VendingMachineServiceLayerImpl implements
        VendingMachineServiceLayer {

    VendingMachineDao dao;
    private VendingMachineAuditDao auditDao;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    //
    //------------------admin service functions----------------------
    //
    //
    @Override
    public void createItem(Item item) throws VendingMachineOutOfStockException,
            VendingMachineDataValidationException,
            VendingMachinePersistenceException {

        if (dao.getItem(item.getName()) != null) {
            throw new VendingMachineOutOfStockException(
                    "ERROR: Could not create Item.  There is already an item named "
                    + item.getName()
                    + ".");
        }

        validateItemData(item);

        dao.addItem(item.getName(), item);

        //auditDao.writeAuditEntry(
               // "Item " + item.getName() + " CREATED.");
    }

    private void validateItemData(Item item) throws
            VendingMachineDataValidationException {

        if (item.getName() == null
                || item.getName().trim().length() == 0
                || item.getCost() == null
                || !(item.getInventoryCount() >= 0)) {

            throw new VendingMachineDataValidationException(
                    "ERROR: All fields [Name, Inventory Count, Cost] are required and the inventory count must be a number equal to or greater than zero.");
        }
    }

    @Override
    public void editItem(String oldName, Item newItem) throws VendingMachineOutOfStockException,
            VendingMachineDataValidationException,
            VendingMachinePersistenceException {

        dao.editItem(oldName, newItem);

        //auditDao.writeAuditEntry(
                //"Item " + newItem.getName() + " Edited.");
    }

    @Override
    public Item getItem(String name) throws VendingMachinePersistenceException {
        return dao.getItem(name);
    }

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
        return dao.getAllItems();
    }

    @Override
    public Item removeItem(String name) throws VendingMachinePersistenceException {
        Item removedItem = dao.removeItem(name);

       // auditDao.writeAuditEntry("Item " + name + " REMOVED.");
        return removedItem;
    }

    //
    //----------------user service functions------------------------
    //
    //
    @Override
    public boolean validateInventory(Item item) throws VendingMachineOutOfStockException {
        if (item.getInventoryCount() > 0) {
            return true;
        } else {
            throw new VendingMachineOutOfStockException(
                    "Item is currently out of stock");

        }
    }

    @Override
    public Item getItemUser(String name) throws VendingMachinePersistenceException {
        Item item = dao.getItem(name);

        try {
            validateInventory(item);
            validateItemData(item);

        } catch (VendingMachineOutOfStockException ex) {
            System.out.println("Item is currently out of stock");
            item = null;

        } catch (VendingMachineDataValidationException | NullPointerException ex) {
            System.out.println("Item does not exist");
            item = null;
        }
        return item;
    }

    @Override
    public void purchaseItem(Item item) throws VendingMachineOutOfStockException,
            VendingMachineDataValidationException,
            VendingMachinePersistenceException {
        
        int oldCount = item.getInventoryCount();
        item.setInventoryCount(oldCount - 1);
        dao.editItem(item.getName(), item);
        //auditDao.writeAuditEntry(
                //"Item " + item.getName() + " Purchased.");
    }

    @Override
    public Change giveChange(BigDecimal bank) {

        BigDecimal totalChange = bank;

        Change itemChange = new Change(totalChange);

        BigDecimal emptyBank = new BigDecimal("00.00");
        BigDecimal quarter = new BigDecimal("00.25");
        BigDecimal dime = new BigDecimal("00.10");
        BigDecimal nickel = new BigDecimal("00.05");
        BigDecimal penny = new BigDecimal("00.01");
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;
        coins coin = null;

        while (bank.compareTo(emptyBank) == 1) {
            while (bank.subtract(quarter).compareTo(emptyBank) != -1) {
                coin = QUARTER;
                break;
            }
            while (bank.subtract(quarter).compareTo(emptyBank) == -1 && bank.subtract(dime).compareTo(emptyBank) != -1) {
                coin = DIME;
                break;
            }
            while (bank.subtract(dime).compareTo(emptyBank) == -1 && bank.subtract(nickel).compareTo(emptyBank) != -1) {
                coin = NICKEL;
                break;
            }
            while (bank.subtract(nickel).compareTo(emptyBank) == -1 && bank.subtract(penny).compareTo(emptyBank) != -1) {
                coin = PENNY;
                break;
            }

            switch (coin) {
                case QUARTER:
                    quarters++;
                    bank = bank.subtract(quarter);
                    break;
                case DIME:
                    dimes++;
                    bank = bank.subtract(dime);
                    break;
                case NICKEL:
                    nickels++;
                    bank = bank.subtract(nickel);
                    break;

                case PENNY:
                    pennies++;
                    bank = bank.subtract(penny);
                    break;
            }
        }
        itemChange.setQuarters(quarters);
        itemChange.setDimes(dimes);
        itemChange.setNickels(nickels);
        itemChange.setPennies(pennies);
        return itemChange;

    }

}
