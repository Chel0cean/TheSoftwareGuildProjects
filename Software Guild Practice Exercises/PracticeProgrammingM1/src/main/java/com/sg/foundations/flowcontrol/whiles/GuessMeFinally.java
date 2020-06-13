
package com.sg.foundations.flowcontrol.whiles;

import java.util.Scanner;

/**
 *
 * @author chelseamiller
 */
public class GuessMeFinally {
    public static void main(String[] args) {
 int number = 12;
 int guess = 0;
 int count = 0;
     
 Scanner inputReader = new Scanner(System.in); 
 
 System.out.println("I've chosen a number 0-20, try to guess it!");
 guess = Integer.parseInt(inputReader.nextLine());
do{
 count++;
 
 if(guess < number){
 
 System.out.println(guess + " is too low, try again:");
 guess = Integer.parseInt(inputReader.nextLine());
 
 }
 else if(guess > number){
 
 System.out.println(guess + " is too high, try again:");
 guess = Integer.parseInt(inputReader.nextLine());
 
 }
 }
 while(guess != number);
 
 
if(guess == number){
    
    if (count == 1)
     System.out.print("Wow, great guess! " + number + " was the number I chose!");
     
   else if(count != 1){
     System.out.println(" Yes, " +number + " was my guess as well. Finally! It's about time you got it!");
 } 
}
 }
    
}
