
package DAO;

import DTO.Car;
import DTO.CarKey;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author chelseamiller
 */
public class CarLotDAOImpl implements CarLotDAO{
    
     private final String ROSTER_FILE;
    public static final String DELIMITER = "::";

    public CarLotDAOImpl() {
        ROSTER_FILE = "roster.txt";
    }

    public CarLotDAOImpl(String rosterTextFile) {
        ROSTER_FILE = rosterTextFile;
    }

    private Map<String, Car> cars = new HashMap<>();
    
   

    @Override
    public Car addCar(String VIN, Car car) throws CarRosterPersistenceException {
       loadRoster();
        Car newCar = cars.put(VIN, car);
        writeRoster();
        return newCar;
    
    }

    @Override
    public Car getCar(String VIN) throws CarRosterPersistenceException {
      loadRoster();
        return cars.get(VIN);
    }

    @Override
    public List<Car> getCars() throws CarRosterPersistenceException {
     loadRoster();
        return new ArrayList(cars.values());
    }

    @Override
    public Car removeCar(String VIN) throws CarRosterPersistenceException  {
        loadRoster();
        Car removedCar = cars.remove(VIN);
        writeRoster();
        return removedCar;
    }
    
    private Car unmarshallCar(String carAsText) {
        String[] carTokens = carAsText.split(DELIMITER);
        String VIN = carTokens[0];
        Car carFromFile = new Car(VIN);
        carFromFile.setVIN(carTokens[0]);
        carFromFile.setMake(carTokens[1]);
        carFromFile.setModel(carTokens[2]);
        carFromFile.setColor(carTokens[3]);
        carFromFile.setPrice(new BigDecimal(carTokens[4]));
        carFromFile.setOdometerMiles(Long.parseLong(carTokens[5]));
        
        return carFromFile;
    }
    
    private void loadRoster() throws CarRosterPersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new CarRosterPersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }
        String currentLine;
        Car currentCar;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentCar = unmarshallCar(currentLine);
            cars.put(currentCar.getVIN(), currentCar);
        }
        scanner.close();
    }
    
     private String marshallCar(Car aCar) {
        String carAsText = aCar.getVIN() + DELIMITER;
        carAsText += aCar.getMake() + DELIMITER;
        carAsText += aCar.getModel() + DELIMITER;
        carAsText += aCar.getColor() + DELIMITER;
        carAsText += aCar.getPrice() + DELIMITER;
        carAsText += aCar.getOdometerMiles() + DELIMITER;
        
        return carAsText;
    }
     
     private void writeRoster() throws CarRosterPersistenceException {
         PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new CarRosterPersistenceException(
                    "Could not save student data.", e);
        }
        String carAsText;
        List<Car> carList = new ArrayList(cars.values());
        for (Car currentCar : carList) {
            carAsText = marshallCar(currentCar);
            out.println(carAsText);
            out.flush();
        }
        out.close();
    }
    
}
