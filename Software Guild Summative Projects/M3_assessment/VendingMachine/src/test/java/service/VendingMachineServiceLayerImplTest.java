package service;

import dao.VendingMachineAuditDao;
import dao.VendingMachineDao;
import dao.VendingMachinePersistenceException;
import dto.Change;
import dto.Item;
import java.math.BigDecimal;
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
public class VendingMachineServiceLayerImplTest {

    private VendingMachineServiceLayer service;

    public VendingMachineServiceLayerImplTest() {
        VendingMachineDao dao = new VendingMachineDaoStubImpl();
        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();

        service = new VendingMachineServiceLayerImpl(dao, auditDao);
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of createItem method, of class VendingMachineServiceLayerImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testCreateItem() throws Exception {
        Item poptarts = new Item("Poptarts");
        poptarts.setName("Poptarts");
        poptarts.setInventoryCount(45);
        poptarts.setCost(new BigDecimal("3.25"));

        try {
            service.createItem(poptarts);
        } catch (VendingMachineOutOfStockException | VendingMachineDataValidationException
                | VendingMachinePersistenceException e) {
            // ASSERT
            fail("item was valid. No exception should have been thrown.");
        }
    }

    /**
     * Test of getAllItems method, of class VendingMachineServiceLayerImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllItems() throws Exception {
        Item cupcakes = new Item("Cupcakes");
        cupcakes.setInventoryCount(10);
        cupcakes.setCost(new BigDecimal("4.00"));

        // ACT & ASSERT
        assertEquals(1, service.getAllItems().size(),
                "Should only have one item.");
        assertTrue(service.getAllItems().contains(cupcakes),
                "The one item should be Cupcakes.");
    }

    /**
     * Test of getItem method, of class VendingMachineServiceLayerImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetItem() throws Exception {
        Item cupcakes = new Item("Cupcakes");
        cupcakes.setInventoryCount(10);
        cupcakes.setCost(new BigDecimal("4.00"));

        Item shouldBeCupcakes = service.getItem("Cupcakes");
        assertNotNull(shouldBeCupcakes, "Getting Cupcakes should be not null.");
        assertEquals(cupcakes, shouldBeCupcakes,
                "Item stored under Cupcakes should be Cupcakes.");

        Item shouldBeNull = service.getItem("Hamburger");
        assertNull(shouldBeNull, "Getting Hamburger should be null.");
    }

    @Test
    public void testGetItemUser() throws Exception {
        System.out.println("getItemUser");

        Item cupcakes = new Item("Cupcakes");
        cupcakes.setInventoryCount(10);
        cupcakes.setCost(new BigDecimal("4.00"));

        Item poptarts = new Item("Poptarts");
        poptarts.setInventoryCount(0);
        poptarts.setCost(new BigDecimal("3.25"));

        Item shouldBeCupcakes = service.getItemUser("Cupcakes");
        Item shouldBePoptarts = service.getItemUser("Poptarts");

        assertEquals(cupcakes, shouldBeCupcakes, "Cupcakes should have been retrieved because it has a positive inventory.");
        assertNull(shouldBePoptarts, "Poptarts should have returned a null object because it has an inventory of 0");
    }

    /**
     * Test of removeItem method, of class VendingMachineServiceLayerImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testRemoveItem() throws Exception {
        Item cupcakes = new Item("Cupcakes");
        cupcakes.setInventoryCount(10);
        cupcakes.setCost(new BigDecimal("4.00"));

        Item shouldBeCupcakes = service.removeItem("Cupcakes");
        assertNotNull(shouldBeCupcakes, "Removing Cupcakes should be not null.");
        assertEquals(cupcakes, shouldBeCupcakes, "item removed from Cupcakes should be Cupcakes.");

        Item shouldBeNull = service.removeItem("Hamburger");
        assertNull(shouldBeNull, "Removing Hamburger should be null.");
    }

    /**
     * Test of validateInventory method, of class
     * VendingMachineServiceLayerImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testValidateInventory() throws Exception {
       Item cupcakes = new Item("Cupcakes");
        cupcakes.setInventoryCount(0);
        cupcakes.setCost(new BigDecimal("4.00"));

        // ACT
        try {
            service.validateInventory(cupcakes);
            fail("Expected ValidationException was not thrown.");

        } catch (VendingMachineOutOfStockException e) {

        }

    }

    /**
     * Test of editItem method, of class VendingMachineServiceLayerImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testEditItem() throws Exception {
        System.out.println("editItem");
        Item poptarts = new Item("Poptarts");
        String nameOrig = "Poptarts";
        int countOrig = 45;
        BigDecimal costOrig = new BigDecimal("3.25");
        poptarts.setInventoryCount(countOrig);
        poptarts.setCost(costOrig);

        int newCount = 10;

        poptarts.setInventoryCount(newCount);

        service.editItem(poptarts.getName(), poptarts);

        assertEquals(service.getItem(nameOrig), poptarts, "Check to see if the items are the same");
    }

    /**
     * Test of purchaseItem method, of class VendingMachineServiceLayerImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testPurchaseItem() throws Exception {
        System.out.println("purchaseItem");

        int oldInventory = 10;

        Item cupcakes = new Item("Cupcakes");
        cupcakes.setInventoryCount(10);
        cupcakes.setCost(new BigDecimal("4.00"));

        service.purchaseItem(cupcakes);

        int newInventory = oldInventory - 1;

        assertEquals(newInventory, cupcakes.getInventoryCount(), "checking to see if the purchase went through and the inventory of the item was adjusted");
    }

    /**
     * Test of giveChange method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testGiveChange() {
        System.out.println("giveChange");

        BigDecimal testBank = new BigDecimal("1.16");

        BigDecimal totalExpected = testBank;
        int quarterCountExpected = 4;
        int dimeCountExpected = 1;
        int nickelCountExpected = 1;
        int pennyCountExpected = 1;

        Change result = service.giveChange(testBank);

        BigDecimal totalResult = result.getTotal();
        int quarterCountResult = result.getQuarters();
        int dimeCountResult = result.getDimes();
        int nickelCountResult = result.getNickels();
        int pennyCountResult = result.getPennies();

        assertEquals(totalExpected, totalResult);
        assertEquals(quarterCountExpected, quarterCountResult);
        assertEquals(dimeCountExpected, dimeCountResult);
        assertEquals(nickelCountExpected, nickelCountResult);
        assertEquals(pennyCountExpected, pennyCountResult);

    }

}
