
package SERVICE;

import DAO.CarKeyDAO;
import DAO.CarKeyDAOImpl;
import DAO.CarLotDAO;
import DAO.CarLotDAOImpl;
import DAO.CarRosterPersistenceException;
import DTO.Car;
import DTO.CarKey;
import java.math.BigDecimal;
import java.util.ArrayList;
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
public class CarLotServiceImplTest {
   private CarLotService service;
    
    
    public CarLotServiceImplTest() {
         CarLotDAO carDao = new CarLotDAOStubImpl();
        CarKeyDAO keyDao = new CarKeyDAOStubImpl();
        service = new CarLotServiceImpl(carDao, keyDao);
       Car car1 = new Car("");
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
     * Test of getACar method, of class CarLotServiceImpl.
     * @throws DAO.CarRosterPersistenceException
     */
    @Test
    public void testAddGetACar() throws CarRosterPersistenceException  {
        
        String VIN = "1";
       Car car1 = new Car(VIN);
        car1.setMake("Toyota");
       car1.setModel("Corolla");
        car1.setColor("blue");
        car1.setPrice(new BigDecimal(25000.00)); 
        car1.setOdometerMiles(0);
        car1.setKey(null);
        Car expResult = car1;
        Car result = service.getACar(VIN);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllCars method, of class CarLotServiceImpl.
     * @throws DAO.CarRosterPersistenceException
     */
    
    
    @Test
    public void testGetAllCars() throws CarRosterPersistenceException {
        
        System.out.println("getAllCars"); 
        assertEquals(1, service.getAllCars().size(),
                "Should only have one car.");
        
    }

    /**
     * Test of getCarsByColor method, of class CarLotServiceImpl.
     * @throws DAO.CarRosterPersistenceException
     */
    
    
    @Test
    public void testGetCarsByColor() throws CarRosterPersistenceException {
         String VIN = "1";
       Car car1 = new Car(VIN);
        car1.setMake("Toyota");
       car1.setModel("Corolla");
        car1.setColor("blue");
        car1.setPrice(new BigDecimal(25000.00)); 
        car1.setOdometerMiles(0);
        car1.setKey(null);
        
        List<Car> testList = new ArrayList();
        testList.add(car1);
        
        System.out.println("getCarsByColor");
        String color = "blue";
        List<Car> expResult = testList;
        List<Car> result = service.getCarsByColor(color);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCarsInBudget method, of class CarLotServiceImpl.
     * @throws DAO.CarRosterPersistenceException
     */
    
    
    @Test
    public void testGetCarsInBudget() throws CarRosterPersistenceException {
        System.out.println("getCarsInBudget");
        BigDecimal maxPrice = new BigDecimal("30000");
        
         String VIN = "1";
       Car car1 = new Car(VIN);
        car1.setMake("Toyota");
       car1.setModel("Corolla");
        car1.setColor("blue");
        car1.setPrice(new BigDecimal(25000.00)); 
        car1.setOdometerMiles(0);
        car1.setKey(null);
        
        List<Car> testList = new ArrayList();
        testList.add(car1);
        
        List<Car> expResult = testList;
        List<Car> result = service.getCarsInBudget(maxPrice);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCarByMakeAndModel method, of class CarLotServiceImpl.
     * @throws DAO.CarRosterPersistenceException
     */
    
    
    @Test
    public void testGetCarByMakeAndModel() throws CarRosterPersistenceException {
        System.out.println("getCarByMakeAndModel");
         String VIN = "1";
       Car car1 = new Car(VIN);
        car1.setMake("Toyota");
       car1.setModel("Corolla");
        car1.setColor("blue");
        car1.setPrice(new BigDecimal(25000.00)); 
        car1.setOdometerMiles(0);
        car1.setKey(null);
        
        List<Car> testList = new ArrayList();
        testList.add(car1);
        
        String make = "Toyota";
        String model = "Corolla";
        List<Car> expResult = testList;
        List<Car> result = service.getCarByMakeAndModel(make, model);
        assertEquals(expResult, result);
    }

    /**
     * Test of discountCar method, of class CarLotServiceImpl.
     * @throws java.lang.Exception
     */
    
    
    @Test
    public void testDiscountCar() throws Exception {
        System.out.println("discountCar");
         String VIN = "1";
       Car car1 = new Car(VIN);
        car1.setMake("Toyota");
       car1.setModel("Corolla");
        car1.setColor("blue");
        car1.setPrice(new BigDecimal(25000.00)); 
        car1.setOdometerMiles(0);
        car1.setKey(null);
        
        List<Car> testList = new ArrayList();
        testList.add(car1);
     
        BigDecimal percentDiscount = new BigDecimal(".15");
        BigDecimal expResult = new BigDecimal("21250.00");
        BigDecimal result = service.discountCar(VIN, percentDiscount);
        assertEquals(expResult, result);
    }

    /**
     * Test of sellCar method, of class CarLotServiceImpl.
     * @throws java.lang.Exception
     */
    
    
    @Test
    public void testSellCar() throws Exception {
        System.out.println("sellCar");
        CarKey key1 = new CarKey();
        key1.setVIN("1");
        key1.setLaserCut(true);
        
        String VIN = "1";
        BigDecimal cashPaid = new BigDecimal("25000.00");
        CarKey expResult = key1;
        CarKey result = service.sellCar(VIN, cashPaid);
        assertEquals(expResult, result);
    }
   
}
