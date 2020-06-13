/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE;

import DAO.CarLotDAO;
import DTO.Car;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chelseamiller
 */
public class CarLotDAOStubImpl implements CarLotDAO{

    
    public Car onlyCar;

    public CarLotDAOStubImpl() {
        
        String VIN = "1";
        onlyCar = new Car(VIN);
        onlyCar.setVIN(VIN);
        onlyCar.setMake("Toyota");
       onlyCar.setModel("Corolla");
        onlyCar.setColor("blue");
        onlyCar.setPrice(new BigDecimal(25000.00)); 
        onlyCar.setOdometerMiles(0);
        onlyCar.setKey(null);
    }

    public CarLotDAOStubImpl(Car testCar){
         this.onlyCar = testCar;
     }

    @Override
    public Car addCar(String VIN, Car car){
        if (VIN.equals(onlyCar.getVIN())) {
            return onlyCar;
        } else {
            return null;
        }
    }

    @Override
    public List<Car> getCars(){
        List<Car> CarList = new ArrayList<>();
        CarList.add(onlyCar);
        return CarList;
    }

    @Override
    public Car getCar(String VIN){
        if (VIN.equals(onlyCar.getVIN())) {
            return onlyCar;
        } else {
            return null;
        }       
    }

    @Override
    public Car removeCar(String VIN){
        if (VIN.equals(onlyCar.getVIN())) {
            return onlyCar;
        } else {
            return null;
        }
    }   

    
}