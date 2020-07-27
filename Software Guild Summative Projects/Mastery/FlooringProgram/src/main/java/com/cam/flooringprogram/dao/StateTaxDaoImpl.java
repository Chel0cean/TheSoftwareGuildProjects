package com.cam.flooringprogram.dao;

import com.cam.flooringprogram.dto.State;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author chelseamiller
 */
public class StateTaxDaoImpl implements StateTaxDao {

    private final String ROSTER_FILE;
    public static final String DELIMITER = ",";
    String Title ="State,StateName,TaxRate";

    public StateTaxDaoImpl() {
        ROSTER_FILE = "state.txt";
    }

    public StateTaxDaoImpl(String stateTextFile) {
        ROSTER_FILE = stateTextFile;
    }
    private Map<String, State> states = new HashMap<>();

    @Override
    public State createState(String abbreviation, State state) throws FlooringProgramPersistenceException{
        loadCollection();
        State newState = states.put(abbreviation, state);
        writeCollection();
        return newState;
    }

    @Override
    public State editState(String oldAbbreviation, State newState) throws FlooringProgramPersistenceException{
        loadCollection();
        states.remove(oldAbbreviation);
        states.put(newState.getName(), newState);
        writeCollection();
        return newState;
    }

    @Override
    public State removeState(String abbreviation) throws FlooringProgramPersistenceException{
    loadCollection();
        State removedState = states.remove(abbreviation);
        writeCollection();
        return removedState;
    }

    @Override
    public State getState(String abbreviation)throws FlooringProgramPersistenceException {
       loadCollection();
        State state;
        try {
            state = states.get(abbreviation);
        } catch (NullPointerException ex) {
            state = null;

        }
        return state;
    }
    
     @Override
    public List<State> getAllStates() throws FlooringProgramPersistenceException{
      loadCollection();
        return new ArrayList(states.values());
    }

    private State unmarshallStateTax(String stateAsText) {
     
        String[] stateTokens = stateAsText.split(DELIMITER);

        String abbreviation = stateTokens[0];
        String name = stateTokens[1];
        BigDecimal taxRate = new BigDecimal(stateTokens[2]);

        State stateFromFile = new State(abbreviation);

        stateFromFile.setName(name);

        stateFromFile.setTaxRate(taxRate);

        return stateFromFile;
    }

    @Override
    public void loadCollection() throws FlooringProgramPersistenceException {
    Scanner scanner;

        try {

            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringProgramPersistenceException(
                    "-_- Could not load collection data into memory.", e);
        }

        String currentLine;

        State currentState;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();
            
            if (!currentLine.contains(Title)){

            currentState = unmarshallStateTax(currentLine);

            states.put(currentState.getAbbreviation(), currentState);
        }
        }
        scanner.close();
    }

    private void writeCollection() throws FlooringProgramPersistenceException{
       PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new FlooringProgramPersistenceException(
                    "Could not save state data.", e);
        }

        String stateAsText;
        List<State> stateList = new ArrayList(states.values());
        out.println(Title);
        for (State currentState : stateList) {

            stateAsText = marshallStateTax(currentState);

            out.println(stateAsText);

            out.flush();
        }

        out.close();
    }
    
    

     private String marshallStateTax(State aState) {
         
      String stateAsText = aState.getAbbreviation() + DELIMITER;

        stateAsText += aState.getName() + DELIMITER;

        stateAsText += aState.getTaxRate().toString();

        return stateAsText;
    }
 
    
   
}

