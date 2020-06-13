
package com.sg.foundations.flowcontrol.fors;

/**
 *
 * @author chelseamiller
 */
public class SpringForwardFallBack {
    public static void main(String[] args) {
        //this loop starts at 0 and runs up to 9 (inclusive).
        System.out.println("It's Spring...!");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + ", ");
       
}
        //this loop starts at 10 and runs down to 1 (inclusive).
        System.out.println("\nOh no, it's fall...");
        for (int i = 10; i > 0; i--) {
            System.out.print(i + ", ");
        }
    }
}
