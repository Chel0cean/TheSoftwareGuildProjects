/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3;

import java.util.Scanner;

/**
 *
 * @author chelseamiller
 */
public class app {

    public static void main(String[] args) {
        //code for first exercise
        /*weekdays weekday = new weekdays();

        String day = weekday.getDay();
        weekdayEnum currentDay = weekdayEnum.valueOf(day);
        System.out.println(weekday.calculateDays(currentDay));
        */
        
        //code for second exercise
        IntMath math = new IntMath();
        int one =math.getoperand1();
        String operand = math.getOperand();
        int two = math.getoperand2();
        IntEnum operandChoice = IntEnum.valueOf(operand);
        System.out.println(math.calculate(operandChoice, one, two));
    } 

}
