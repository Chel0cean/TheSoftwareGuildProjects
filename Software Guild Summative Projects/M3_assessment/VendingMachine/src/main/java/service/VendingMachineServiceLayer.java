
package service;

import dao.VendingMachinePersistenceException;
import dto.Change;
import dto.coins;
import dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author chelseamiller
 */
public interface VendingMachineServiceLayer {
    void createItem(Item item) throws
            VendingMachineOutOfStockException,
            VendingMachineDataValidationException,
            VendingMachinePersistenceException;

    List<Item> getAllItems() throws
            VendingMachinePersistenceException;

    Item getItem(String name) throws
            VendingMachinePersistenceException;
    
    Item getItemUser(String name) throws VendingMachinePersistenceException, VendingMachineOutOfStockException;

    Item removeItem(String name) throws
            VendingMachinePersistenceException;

   void editItem(String name, Item item) throws VendingMachineOutOfStockException,
            VendingMachineDataValidationException,
            VendingMachinePersistenceException ;
   
   boolean validateInventory(Item item) throws VendingMachineOutOfStockException;
   
   void purchaseItem(Item item)throws VendingMachineOutOfStockException,
            VendingMachineDataValidationException,
            VendingMachinePersistenceException;
   
    public Change giveChange(BigDecimal bank);
}
