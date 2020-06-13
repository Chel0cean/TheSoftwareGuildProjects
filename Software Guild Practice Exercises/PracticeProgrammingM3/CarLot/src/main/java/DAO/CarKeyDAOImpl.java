/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.CarLotDAOImpl.DELIMITER;
import DTO.Car;
import DTO.CarKey;
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
public class CarKeyDAOImpl implements CarKeyDAO {

    private final String ROSTER_FILE;
    public static final String DELIMITER = "::";

    public CarKeyDAOImpl() {
        ROSTER_FILE = "keyroster.txt";
    }

    public CarKeyDAOImpl(String rosterTextFile) {
        ROSTER_FILE = rosterTextFile;
    }

    private Map<String, CarKey> keys = new HashMap<>();

    public CarKey addKey(String VIN, CarKey key) throws CarRosterPersistenceException {
        loadRoster();
        CarKey newKey = keys.put(VIN, key);
        writeRoster();
        return newKey;
    }

    @Override
    public CarKey getKey(String VIN) throws CarRosterPersistenceException {
        loadRoster();
        return keys.get(VIN);
    }

    @Override
    public List<CarKey> getKeys() throws CarRosterPersistenceException {
        loadRoster();
        return new ArrayList(keys.values());
    }

    @Override
    public CarKey removeKey(String VIN) throws CarRosterPersistenceException {
        loadRoster();
        CarKey removedKey = keys.remove(VIN);
        writeRoster();
        return removedKey;
    }
 private CarKey unmarshallCarKey(String keyAsText) {
        String[] keyTokens = keyAsText.split(DELIMITER);
        String VIN = keyTokens[0];
        CarKey keyFromFile = new CarKey();
        keyFromFile.setVIN(keyTokens[0]);
        keyFromFile.setLaserCut(Boolean.parseBoolean(keyTokens[1]));
        return keyFromFile;
    }
    
    private void loadRoster() throws CarRosterPersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new CarRosterPersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }
        String currentLine;
        CarKey currentKey;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentKey = unmarshallCarKey(currentLine);
            keys.put(currentKey.getVIN(), currentKey);
        }
        scanner.close();
    }
    
     private String marshallCarKey(CarKey aKey) {
        String keyAsText = aKey.getVIN() + DELIMITER;
        keyAsText += aKey.isLaserCut();
        return keyAsText;
    }
     
     private void writeRoster() throws CarRosterPersistenceException {
         PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new CarRosterPersistenceException(
                    "Could not save car key data.", e);
        }
        String keyAsText;
        List<CarKey> keyList = new ArrayList(keys.values());
        for (CarKey currentkey : keyList) {
            keyAsText = marshallCarKey(currentkey);
            out.println(keyAsText);
            out.flush();
        }
        out.close();
    }

    @Override
    public CarKey addKey(String VIN, boolean laserCut) throws CarRosterPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}