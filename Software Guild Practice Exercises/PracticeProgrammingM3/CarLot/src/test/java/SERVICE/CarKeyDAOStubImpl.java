/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICE;

import DAO.CarKeyDAO;
import DAO.CarRosterPersistenceException;
import DTO.CarKey;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chelseamiller
 */
public class CarKeyDAOStubImpl implements CarKeyDAO {
    public CarKey onlyKey;
    
    public CarKeyDAOStubImpl(){
        onlyKey = new CarKey();
        String VIN = "1";
        onlyKey.setVIN(VIN);
        onlyKey.setLaserCut(true);
    }
    
    public CarKeyDAOStubImpl (CarKey testKey){
        this.onlyKey = testKey;
    }

    @Override
    public CarKey addKey(String VIN, boolean laserCut)  {
      if (VIN.equals(onlyKey.getVIN())) {
            return onlyKey;
        } else {
            return null;
        }
    }

    @Override
    public CarKey getKey(String VIN)  {
      if (VIN.equals(onlyKey.getVIN())) {
            return onlyKey;
        } else {
            return null;
        }
    }

    @Override
     public List<CarKey> getKeys() {
       List<CarKey> keyList = new ArrayList<>();
        keyList.add(onlyKey);
        return keyList;
    }
    
    @Override
    public CarKey removeKey(String VIN) {
      if (VIN.equals(onlyKey.getVIN())) {
            return onlyKey;
        } else {
            return null;
        }
    }
    
}
