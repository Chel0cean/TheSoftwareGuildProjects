
package DAO;

import DTO.Car;
import java.util.List;

/**
 *
 * @author chelseamiller
 */
public interface CarLotDAO {
    public Car addCar(String VIN, Car car) throws CarRosterPersistenceException;    

    public Car getCar(String VIN) throws CarRosterPersistenceException;    
    public List<Car> getCars() throws CarRosterPersistenceException;

    public Car removeCar(String VIN) throws CarRosterPersistenceException;    
}
