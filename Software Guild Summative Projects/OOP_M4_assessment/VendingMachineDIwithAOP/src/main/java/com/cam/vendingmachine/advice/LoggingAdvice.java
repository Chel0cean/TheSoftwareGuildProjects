
package com.cam.vendingmachine.advice;

import com.cam.vendingmachine.dao.VendingMachineAuditDao;
import com.cam.vendingmachine.dao.VendingMachinePersistenceException;
import com.cam.vendingmachine.dto.Item;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author chelseamiller
 */
public class LoggingAdvice {
    VendingMachineAuditDao auditDao;
    public LoggingAdvice(VendingMachineAuditDao auditDao) {
        this.auditDao = auditDao;
    }
    
    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VendingMachinePersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
    
    public void createPurchaseAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = "Item Purchased" + ": ";
        Item item = (Item)args[0];
        auditEntry += item.getName() + " |  New Count: " + item.getInventoryCount();
        
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VendingMachinePersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
}