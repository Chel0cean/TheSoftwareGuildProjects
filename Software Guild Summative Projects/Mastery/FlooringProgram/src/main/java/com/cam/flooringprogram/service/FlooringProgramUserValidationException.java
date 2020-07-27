/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cam.flooringprogram.service;

/**
 *
 * @author chelseamiller
 */
public class FlooringProgramUserValidationException extends Exception {
         public FlooringProgramUserValidationException(String message) {
        super(message);
    }

    public FlooringProgramUserValidationException(String message, Throwable cause) {
        super(message, cause);
    }
  
    
}
