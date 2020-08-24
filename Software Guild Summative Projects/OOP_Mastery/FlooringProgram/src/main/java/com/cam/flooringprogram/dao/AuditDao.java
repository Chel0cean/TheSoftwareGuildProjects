
package com.cam.flooringprogram.dao;

/**
 *
 * @author chelseamiller
 */
public interface AuditDao {
    public void writeAuditEntry(String Entry)throws FlooringProgramPersistenceException;
        
   
}
