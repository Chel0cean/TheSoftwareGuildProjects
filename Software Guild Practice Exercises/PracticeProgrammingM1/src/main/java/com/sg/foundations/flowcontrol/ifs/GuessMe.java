
package com.sg.foundations.flowcontrol.ifs;
import java.util.Scanner;
/**
 *
 * @author chelseamiller
 */
public class GuessMe {
 public static void main(String[] args) {
 int number = 12;
 int guess = 0;
     
 Scanner inputReader = new Scanner(System.in); 
 
 System.out.println("I've chosen a number 0-20, try to guess it!");
 guess = Integer.parseInt(inputReader.nextLine());
do{
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
     System.out.print("Wow, great guess! " + number + " was the number I chose!");
     
 
 }   
}
}
