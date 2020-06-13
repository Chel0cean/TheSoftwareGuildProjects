package dao;

import dto.Item;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author chelseamiller
 */
public class VendingMachineDaoFileImplTest {

    VendingMachineDao testDao;

    public VendingMachineDaoFileImplTest() {
    }

    @BeforeAll
    public static void setUpClass() {

    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() throws IOException {
        String testFile = "testroster.txt";

        new FileWriter(testFile);
        testDao = new VendingMachineDaoFileImpl(testFile);
    }

    @AfterEach
    public void tearDown() {

    }

    /**
     * Test of addItem method, of class VendingMachineDaoFileImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAddGetItem() throws Exception {
        System.out.println("addItem");
        String name = "Cupcakes";
        Item item = new Item(name);
        item.setInventoryCount(35);
        item.setCost(new BigDecimal("2.00"));

        testDao.addItem(name, item);

        Item retrievedItem = testDao.getItem(name);

        assertEquals(item.getName(),
                retrievedItem.getName(),
                "Checking item name.");
        assertEquals(item.getInventoryCount(),
                retrievedItem.getInventoryCount(),
                "Checking item Inventory Count.");
        assertEquals(item.getCost(),
                retrievedItem.getCost(),
                "Checking item cost.");

    }

    @Test
    public void testEditItem() throws Exception {
        System.out.println("editItem");
        String name = "Cupcakes";
        Item item = new Item(name);
        int oldInventoryCount = 35;
        BigDecimal oldCost = new BigDecimal("2.00");
        item.setInventoryCount(oldInventoryCount);
        item.setCost(oldCost);
        testDao.addItem(name, item);

        VendingMachineDaoFileImpl instance = new VendingMachineDaoFileImpl();
        instance.editItem(name, item);

        assertEquals(instance.getItem(name), item, "checking to see if Cupcakes is still the same in the file");

    }

    /**
     * Test of getAllItems method, of class VendingMachineDaoFileImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllItems() throws Exception {
        System.out.println("getAllItems");

        String name = "Cupcakes";
        Item item = new Item(name);
        item.setName(name);
        item.setInventoryCount(35);
        item.setCost(new BigDecimal("2.00"));

        String name2 = "Poptarts";
        Item item2 = new Item(name2);
        item2.setName(name2);
        item2.setInventoryCount(12);
        item2.setCost(new BigDecimal("1.00"));

        testDao.addItem(name, item);
        testDao.addItem(name2, item2);

        List<Item> allItems = testDao.getAllItems();

        assertNotNull(allItems, "The list of items must not be null");
        assertEquals(2, allItems.size(), "List of items should have 2 items.");

        assertTrue(testDao.getAllItems().contains(item),
                "The list of items should include Cupcakes.");
        assertTrue(testDao.getAllItems().contains(item2),
                "The list of items should include Poptarts.");

    }

    /**
     * Test of removeItem method, of class VendingMachineDaoFileImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testRemoveItem() throws Exception {
        System.out.println("removeItem");

        String name = "Cupcakes";
        Item item = new Item(name);
        item.setName(name);
        item.setInventoryCount(35);
        item.setCost(new BigDecimal("2.00"));

        String name2 = "Poptarts";
        Item item2 = new Item(name2);
        item2.setName(name2);
        item2.setInventoryCount(12);
        item2.setCost(new BigDecimal("1.00"));

        testDao.addItem(name, item);
        testDao.addItem(name2, item2);

        Item removedItem = testDao.removeItem(item.getName());

        assertEquals(removedItem.getName(), item.getName(), "the removed item should be Cupcakes");

        List<Item> allItems = testDao.getAllItems();

        assertNotNull(allItems, "The list of items must not be null");
        assertEquals(1, allItems.size(), "List of items should have 1 item.");

        assertTrue(testDao.getAllItems().contains(item2),
                "The list of items should include Poptarts.");

    }

}
