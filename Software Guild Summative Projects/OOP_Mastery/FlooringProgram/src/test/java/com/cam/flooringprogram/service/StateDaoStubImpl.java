/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cam.flooringprogram.service;

import com.cam.flooringprogram.dao.FlooringProgramPersistenceException;
import com.cam.flooringprogram.dao.StateTaxDao;
import com.cam.flooringprogram.dto.State;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chelseamiller
 */
public class StateDaoStubImpl implements StateTaxDao{
    State onlyState;
    
    public StateDaoStubImpl(){
        onlyState= new State("HI");
        
        onlyState.setName("Hawaii");
        onlyState.setTaxRate(new BigDecimal("4"));
          
    }
    
public StateDaoStubImpl(State thisState){
    this.onlyState =thisState;
}
    @Override
    public State createState(String abbreviation, State state) throws FlooringProgramPersistenceException {
   if (abbreviation.equals(onlyState.getAbbreviation())) {
            return onlyState;
        } else {
            return null;
        }
    }

    @Override
    public State editState(String abbreviation, State newState) throws FlooringProgramPersistenceException {
  onlyState.setAbbreviation(abbreviation);
     onlyState = newState;
        return onlyState;
         }

    @Override
    public State removeState(String abbreviation) throws FlooringProgramPersistenceException {
  if (abbreviation.equals(onlyState.getAbbreviation())) {
            return onlyState;
        } else {
            return null;
        }
    }  
    

    @Override
    public State getState(String abbreviation) throws FlooringProgramPersistenceException {
  if (abbreviation.equals(onlyState.getAbbreviation())) {
            return onlyState;
        } else {
            return null;
        }      }

    @Override
    public List<State> getAllStates() throws FlooringProgramPersistenceException {
    List<State> stateList = new ArrayList<>();
        stateList.add(onlyState);
        return stateList;    }

    @Override
    public void loadCollection() throws FlooringProgramPersistenceException {
    }
    
}
