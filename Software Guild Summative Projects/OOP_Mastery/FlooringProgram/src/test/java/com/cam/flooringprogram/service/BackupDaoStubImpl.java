/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cam.flooringprogram.service;

import com.cam.flooringprogram.dao.BackupDao;
import com.cam.flooringprogram.dao.FlooringProgramPersistenceException;
import com.cam.flooringprogram.dto.Order;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author chelseamiller
 */
public class BackupDaoStubImpl implements BackupDao{
    
    

    @Override
    public void WriteBackupEntry(HashMap<LocalDate, Map<Integer, Order>> allOrders) throws FlooringProgramPersistenceException {
//do nothing
    }

    @Override
    public String MarshallOrders(Order orders) {
        return null;
//do nothing
    }
    
}
