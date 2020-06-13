/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.FileNotFoundException;

/**
 *
 * @author chelseamiller
 */
public class CarRosterPersistenceException extends Exception {

    public CarRosterPersistenceException(String message) {
        super(message);
    }

    public CarRosterPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
