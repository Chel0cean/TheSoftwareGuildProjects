package com.sg.foundations.userinput;



import java.util.Scanner;
/**
 *
 * @author chelseamiller
 */
public class AllTheTrivia {
   public static void main(String[] args){
       int earthXSun, waterBoil;
       String fastestMammal, humanMaterial;
       
   Scanner inputReader = new Scanner(System.in); 
   
   System.out.println("How many times does the earth rotate around the sun in a year? ");
   earthXSun = Integer.parseInt(inputReader.nextLine());
   System.out.println("What is the fastest running mammal?");
   fastestMammal = inputReader.nextLine();
   System.out.println("What material makes up most of human composition?");
   humanMaterial = inputReader.nextLine();
   System.out.println("At what degree fahrenheit does water boil?");
   waterBoil = Integer.parseInt(inputReader.nextLine());
   
   System.out.println("Wow! The earth rotates around the sun " + waterBoil + " times! Who knew!");
   System.out.println("I didn't know that the fastest running mammal was "+ humanMaterial+ "!");
   System.out.println("That's amazing that " + fastestMammal + " makes up most of a human's composition!");
   System.out.print("Hmm water boils at " + earthXSun + " fahrenheit, neat!");
      
   } 
}
