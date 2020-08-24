
package service;

import dao.VendingMachineAuditDao;
import dao.VendingMachinePersistenceException;

/**
 *
 * @author chelseamiller
 */
public class VendingMachineAuditDaoStubImpl implements VendingMachineAuditDao{
    @Override
    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException{
        //do nothing . . .
    } 
}
