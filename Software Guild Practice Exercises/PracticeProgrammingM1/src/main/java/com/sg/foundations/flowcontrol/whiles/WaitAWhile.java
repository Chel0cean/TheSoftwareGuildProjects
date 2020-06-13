
package com.sg.foundations.flowcontrol.whiles;

/**
 *
 * @author chelseamiller
 */
public class WaitAWhile {
     public static void main(String[] args) {

        int timeNow = 11;
        int bedTime = 10;

        while (timeNow < bedTime) {
            System.out.println("It's only " + timeNow + " o'clock!");
            System.out.println("I think I'll stay up just a liiiiittle longer....");
            timeNow++; // Time passes
        }

        System.out.println("Oh. It's " + timeNow + " o'clock.");
        System.out.println("Guess I should go to bed ...");
    }
}
