package dao;

import dto.Item;
import java.util.List;

/**
 *
 * @author chelseamiller
 */
public interface VendingMachineDao {

    Item addItem(String name, Item item)
            throws VendingMachinePersistenceException;

    public void editItem(String name, Item item) throws VendingMachinePersistenceException;

    Item getItem(String name)
            throws VendingMachinePersistenceException;

    List<Item> getAllItems()
            throws VendingMachinePersistenceException;

    Item removeItem(String name)
            throws VendingMachinePersistenceException;

}
