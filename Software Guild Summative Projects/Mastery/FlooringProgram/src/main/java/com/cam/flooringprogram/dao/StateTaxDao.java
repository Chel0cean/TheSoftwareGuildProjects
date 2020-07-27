package com.cam.flooringprogram.dao;

import com.cam.flooringprogram.dto.State;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author chelseamiller
 */
public interface StateTaxDao {

    public State createState(String abbreviation, State state)throws FlooringProgramPersistenceException;

    public State editState(String oldAbbreviation, State newState)throws FlooringProgramPersistenceException;

    public State removeState(String abbreviation)throws FlooringProgramPersistenceException;

    public State getState(String abbreviation)throws FlooringProgramPersistenceException;
    
    public List<State> getAllStates()throws FlooringProgramPersistenceException;
   
    public void loadCollection()throws FlooringProgramPersistenceException;


}
