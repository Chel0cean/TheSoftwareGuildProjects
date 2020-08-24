
package com.cam.flooringprogram.dao;

import com.cam.flooringprogram.dto.Order;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chelseamiller
 */
public interface BackupDao {
    public void WriteBackupEntry(HashMap<LocalDate, Map<Integer, Order>> allOrders) throws FlooringProgramPersistenceException;
    public String MarshallOrders(Order orders);
}
