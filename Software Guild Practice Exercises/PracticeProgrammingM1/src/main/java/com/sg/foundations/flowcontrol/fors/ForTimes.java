
package com.sg.foundations.flowcontrol.fors;
import java.util.Scanner;
/**
 *
 * @author chelseamiller
 */
public class ForTimes {
    public static void main(String[] args ){
        int count, X;
        
  Scanner inputReader = new Scanner(System.in);
  System.out.println("Which times table should I recite? ");
  count = Integer.parseInt(inputReader.nextLine());
  for(int i=1; i<=15; i++){
      X = i * count;
      System.out.println(i + " * " +count + " is: " + X);
  }
    }
}
