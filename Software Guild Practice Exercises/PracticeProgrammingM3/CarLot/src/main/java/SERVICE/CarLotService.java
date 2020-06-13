
package SERVICE;

import DAO.CarRosterPersistenceException;
import DTO.Car;
import DTO.CarKey;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author chelseamiller
 */
public interface CarLotService {

    public Car getACar(String VIN)throws CarRosterPersistenceException;    
    public List<Car> getAllCars() throws CarRosterPersistenceException;
    public List<Car> getCarsByColor(String color) throws CarRosterPersistenceException;
    public List<Car> getCarsInBudget(BigDecimal maxPrice) throws CarRosterPersistenceException;
    public List<Car> getCarByMakeAndModel(String make, String model) throws CarRosterPersistenceException;

    public BigDecimal discountCar(String VIN, BigDecimal percentDiscount)
        throws NoSuchCarException, CarRosterPersistenceException;

    public CarKey sellCar(String VIN, BigDecimal cashPaid)
        throws NoSuchCarException,
        OverpaidPriceException,
        UnderpaidPriceException,
        CarRosterPersistenceException;
}