/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cam.flooringprogram.service;

import com.cam.flooringprogram.dao.AuditDao;
import com.cam.flooringprogram.dao.FlooringProgramPersistenceException;

/**
 *
 * @author chelseamiller
 */
public class AuditDaoStubImpl implements AuditDao{
       @Override
    public void writeAuditEntry(String entry) throws FlooringProgramPersistenceException{
        //do nothing . . .
    }  
}
