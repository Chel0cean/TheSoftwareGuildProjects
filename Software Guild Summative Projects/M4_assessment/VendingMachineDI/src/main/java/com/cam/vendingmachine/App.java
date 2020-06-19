
package com.cam.vendingmachine;

import com.cam.vendingmachine.controller.VendingMachineController;
import com.cam.vendingmachine.dao.VendingMachinePersistenceException;
import com.cam.vendingmachine.service.VendingMachineDataValidationException;
import com.cam.vendingmachine.service.VendingMachineOutOfStockException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author chelseamiller
 */
public class App {
    public static void main(String[] args) throws VendingMachineDataValidationException, VendingMachineOutOfStockException, VendingMachinePersistenceException {
        ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        VendingMachineController controller = 
           ctx.getBean("controller", VendingMachineController.class);
        controller.run();
    }
}
