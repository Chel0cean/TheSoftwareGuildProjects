
package com.cam.vendingmachine.dao;

/**
 *
 * @author chelseamiller
 */
public interface VendingMachineAuditDao {
    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException; 
}
