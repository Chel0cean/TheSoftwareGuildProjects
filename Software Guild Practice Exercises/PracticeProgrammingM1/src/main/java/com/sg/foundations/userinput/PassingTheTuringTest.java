
package com.sg.foundations.userinput;
import java.util.Scanner;
/**
 *
 * @author chelseamiller
 */
public class PassingTheTuringTest {
    public static void main(String[] args) {
      String name, color, food;
      double number;
      
      Scanner inputReader = new Scanner(System.in);
      
      System.out.println("What is your name? ");
      name = inputReader.nextLine();
      System.out.println("Nice to meet you " + name + ", my name is Chelsea.");
      System.out.println("What's your favorite color?");
      color = inputReader.nextLine();
      System.out.println("Nice! All of my favorite flowers are " + color +"!");
      System.out.println("What's your favorite food?");
      food = inputReader.nextLine();
      System.out.println("I've never had " + food + ", I'll have to try it!");
      System.out.println("What's your favorite number? ");
      number = Integer.parseInt(inputReader.nextLine());
      System.out.println("Wow, " + number + " is my favorite number too!");
      System.out.print("It's been nice chatting with you, goodbye for now! ");
    }
    
  
}
