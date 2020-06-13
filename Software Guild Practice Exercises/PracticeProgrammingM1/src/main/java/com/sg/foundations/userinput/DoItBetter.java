
package com.sg.foundations.userinput;
import java.util.Scanner;
/**
 *
 * @author chelseamiller
 */
public class DoItBetter {
    public static void main(String[] args){
     int uMiles, myMiles, uHot, myHot, uLan, myLan;
     
     Scanner inputReader = new Scanner(System.in); 
     
    System.out.println("How many miles can you run?");
    uMiles = Integer.parseInt(inputReader.nextLine());
    myMiles = uMiles * 2 + 1;
    
    System.out.println(uMiles + " miles, that's pretty good. I can run " + myMiles + ".");
    
    System.out.println("How many hot dogs can you eat? ");
    uHot = Integer.parseInt(inputReader.nextLine());
    myHot = uHot * 2 + 1;
    
    System.out.println(uHot + " hot dogs is a good start. I can eat "+ myHot+ ".");
    
    System.out.println("How many languages can you speak?");
    uLan = Integer.parseInt(inputReader.nextLine());
    myLan = uLan * 2 + 1;
    
    System.out.println(uLan + "? That's impressive! I personally speak "+ myLan);
    }
    
}
