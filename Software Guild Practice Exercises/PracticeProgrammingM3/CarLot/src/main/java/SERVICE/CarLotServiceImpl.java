package SERVICE;

import DAO.CarKeyDAO;
import DAO.CarLotDAO;
import DAO.CarLotDAOImpl;
import DAO.CarRosterPersistenceException;
import DTO.Car;
import DTO.CarKey;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author chelseamiller
 */
public class CarLotServiceImpl implements CarLotService {

    CarLotDAO carDao;
    CarKeyDAO keyDao;
    public Car Car;
    
     public CarLotServiceImpl(CarLotDAO carDao, CarKeyDAO keyDao) {
        this.carDao = carDao;
        this.keyDao = keyDao;
    }

    @Override
    public Car getACar(String VIN) throws CarRosterPersistenceException {
        return carDao.getCar(VIN);
    }

    @Override
    public List<Car> getAllCars() throws CarRosterPersistenceException {
        return carDao.getCars();
    }

    @Override
    public List<Car> getCarsByColor(String color) throws CarRosterPersistenceException {
        List<Car> carsByColor = carDao.getCars();
        for (int i = 0; i < carsByColor.size(); i++) {
            if (!((carsByColor.get(i).getColor()).equals(color))) {
                carsByColor.remove(i);
            }
        }
        return carsByColor;
    }

    @Override
    public List<Car> getCarsInBudget(BigDecimal maxPrice) throws CarRosterPersistenceException {
        List<Car> carsInBudget = carDao.getCars();
        for (int i = 0; i < carsInBudget.size(); i++) {
            if (carsInBudget.get(i).getPrice().compareTo(maxPrice) == 1) {
                carsInBudget.remove(i);
            }
        }
        return carsInBudget;
    }

    @Override
    public List<Car> getCarByMakeAndModel(String make, String model) throws CarRosterPersistenceException {
        List<Car> carsByType = carDao.getCars();
        for (int i = 0; i < carsByType.size(); i++) {
            if (!((carsByType.get(i).getMake()).equals(make))) {
                carsByType.remove(i);
                if (!((carsByType.get(i).getModel()).equals(model))) {
                    carsByType.remove(i);
                }
            }
        }
        return carsByType;
    }

    @Override
    public BigDecimal discountCar(String VIN, BigDecimal percentDiscount) throws NoSuchCarException, CarRosterPersistenceException {
        Car thisCar = carDao.getCar(VIN);
        BigDecimal oldPrice = thisCar.getPrice();
        BigDecimal newPrice = oldPrice.subtract(percentDiscount.multiply(oldPrice));
        thisCar.setPrice(newPrice);
        return newPrice;
    }

    @Override
    public CarKey sellCar(String VIN, BigDecimal cashPaid) throws NoSuchCarException, OverpaidPriceException, UnderpaidPriceException, CarRosterPersistenceException {
        CarKey thisKey;
        Car thisCar;
        if (carDao.getCar(VIN) == null) {
            throw new NoSuchCarException("No car found with matching VIN");
        } else {
            thisCar = carDao.getCar(VIN);
        }
        if (thisCar.getPrice().compareTo(cashPaid) == 1) {
            throw new UnderpaidPriceException("The cash offered is not enough to buy this car.");
        }
        if (thisCar.getPrice().compareTo(cashPaid) == -1) {
            throw new OverpaidPriceException("The cash offered is more than the price of this car.");
        } else {
            thisKey = keyDao.getKey(VIN);
            carDao.removeCar(VIN);
        }
        return thisKey;
    }
}
