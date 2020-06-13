
package DAO;

import DTO.CarKey;
import java.util.List;

/**
 *
 * @author chelseamiller
 */
public interface CarKeyDAO {
  public CarKey addKey(String VIN, boolean laserCut) throws CarRosterPersistenceException;    

    public CarKey getKey(String VIN) throws CarRosterPersistenceException;    
    public List<CarKey> getKeys() throws CarRosterPersistenceException;  

    public CarKey removeKey(String VIN) throws CarRosterPersistenceException;      
}
