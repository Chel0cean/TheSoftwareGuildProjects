
package com.sg.foundations.flowcontrol.fors;
import java.util.Scanner;
/**
 *
 * @author chelseamiller
 */
public class TwoForsAndTenYearsAgo {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("What year would you like to count back from? ");
        int year = userInput.nextInt();
        //this loop iterates 10 times from 0-10 and 2020-2010
        //*this loop is clearer to me because it uses less math.
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " years ago would be " + (year - i));
        }

        System.out.println("\nI can count backwards using a different way too...");
        //this loop iterates 10 times from 2020-2010.
        for (int i = year; i >= year - 20; i--) {
            System.out.println( (year - i) + " years ago would be " + i);
        }
    }
    
}
