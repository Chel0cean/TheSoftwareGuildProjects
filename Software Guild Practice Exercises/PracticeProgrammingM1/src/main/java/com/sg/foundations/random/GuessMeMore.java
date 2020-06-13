
package com.sg.foundations.random;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author chelseamiller
 */
public class GuessMeMore {
 public static void main(String[] args){
 Random randomizer = new Random();
 Scanner inputReader = new Scanner(System.in);
  int number, guess;
 number = randomizer.nextInt((101 + 101) - 101);
 
 System.out.println("I've chosen a random number from -100 to 100, try to guess it!");
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
