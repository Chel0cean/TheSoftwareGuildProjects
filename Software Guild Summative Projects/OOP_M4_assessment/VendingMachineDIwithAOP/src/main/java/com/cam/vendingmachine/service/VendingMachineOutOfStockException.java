
package com.cam.vendingmachine.service;

/**
 *
 * @author chelseamiller
 */
public class VendingMachineOutOfStockException extends Exception {

    public VendingMachineOutOfStockException(String message) {
        super(message);
    }

    public VendingMachineOutOfStockException(String message,
            Throwable cause) {
        super(message, cause);
    }
    
}
