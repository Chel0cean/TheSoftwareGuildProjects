
package com.cam.vendingmachine.service;

import com.cam.vendingmachine.dao.VendingMachineAuditDao;
import com.cam.vendingmachine.dao.VendingMachinePersistenceException;

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
