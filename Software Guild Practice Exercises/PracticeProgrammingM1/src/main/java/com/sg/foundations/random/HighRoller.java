
package com.sg.foundations.random;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author chelseamiller
 */
public class HighRoller {
    public static void main(String[] args) {
        int dieSides;

        Random diceRoller = new Random();
        Scanner inputReader = new Scanner(System.in);

        
        System.out.println("Hey! How many sides does your die have?");
        dieSides = Integer.parseInt(inputReader.nextLine());
        
        int rollResult = diceRoller.nextInt(dieSides) + 1;
        
        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        System.out.println("I rolled a " + rollResult);

        if (rollResult == 1) {
            System.out.println("You rolled a critical failure!");
        }
        if (rollResult == dieSides){
            System.out.println("You rolled a critical! Nice job!");
        }
    }
    
}
