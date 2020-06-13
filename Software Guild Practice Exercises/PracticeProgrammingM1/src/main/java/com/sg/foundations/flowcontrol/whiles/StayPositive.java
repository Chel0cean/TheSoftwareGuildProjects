
package com.sg.foundations.flowcontrol.whiles;
import java.util.Scanner;
/**
 *
 * @author chelseamiller
 */
public class StayPositive {
 public static void main(String[] args){
     Scanner inputReader = new Scanner(System.in);
     int countdown;
     System.out.println("What number should I count down from?");
     countdown = Integer.parseInt(inputReader.nextLine());
     while(countdown > 0){
         System.out.println(countdown);
         countdown--;
     }
     System.out.println("Blastoff!");
             
 }   
}
