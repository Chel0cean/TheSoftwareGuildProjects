package com.cam.flooringprogram;

import com.cam.flooringprogram.controller.FlooringProgramController;
import com.cam.flooringprogram.dao.FlooringProgramPersistenceException;
import com.cam.flooringprogram.service.FlooringProgramUserValidationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author chelseamiller
 */
public class App {

    public static void main(String[] args) throws FlooringProgramPersistenceException, FlooringProgramUserValidationException {

        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        FlooringProgramController controller
                = ctx.getBean("controller", FlooringProgramController.class);
        controller.run();
    }

}
