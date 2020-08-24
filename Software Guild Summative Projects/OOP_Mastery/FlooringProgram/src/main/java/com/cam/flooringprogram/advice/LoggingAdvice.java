
package com.cam.flooringprogram.advice;

import com.cam.flooringprogram.dao.AuditDao;
import com.cam.flooringprogram.dao.FlooringProgramPersistenceException;
import com.cam.flooringprogram.service.FlooringProgramUserValidationException;
import java.time.LocalDate;
import java.time.LocalTime;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author chelseamiller
 */
public class LoggingAdvice {
     AuditDao auditDao;
    public LoggingAdvice(AuditDao auditDao) {
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
        } catch (FlooringProgramPersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
    
    public void createExportEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = "Data Exported to backup file on" + ": ";
       
        auditEntry += LocalDate.now().atTime(LocalTime.MIN);
        
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (FlooringProgramPersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
    
     public void createFlooringProgramPersistenceExceptionEntry(FlooringProgramPersistenceException ex) {
     
        String auditEntry = "Exception Thrown: " + ex.getMessage();
       
        auditEntry += LocalDate.now().atTime(LocalTime.MIN);
        
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (FlooringProgramPersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
       public void createFlooringProgramUserValidationExceptionEntry(FlooringProgramUserValidationException ex) {
     
        String auditEntry = "Exception Thrown: " + ex.getMessage();
       
        auditEntry += LocalDate.now().atTime(LocalTime.MIN);
        
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (FlooringProgramPersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
}
