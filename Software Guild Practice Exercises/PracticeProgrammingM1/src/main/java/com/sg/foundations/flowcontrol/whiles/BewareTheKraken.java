
package com.sg.foundations.flowcontrol.whiles;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author chelseamiller
 */
public class BewareTheKraken {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        Random randomizer = new Random(); 
        System.out.println("Already, get those flippers and wetsuit on - we're going diving!");
        System.out.println("Here we goooOOooOooo.....! *SPLASH*");
        
        String [] fish = {"Swordfish", "Rainbow Trout", "Goldfish", "Atlantic Cod"};
        int depthDivedInFt = 0;
        String keepGoing = "y";
        // Turns out the ocean is only so deep, 36200 at the deepest survey,
        // so if we reach the bottom ... we should probably stop.
        while(depthDivedInFt < 36200){
            
             if(keepGoing.equals("y")){
             depthDivedInFt += 1000;
             System.out.println("So far, we've swum " + depthDivedInFt + " feet");
             int i = (randomizer.nextInt(3-0)+0);
              System.out.println("You've just passed a "+fish[i] +"!");
             
            System.out.println("Should we keep going? y/n");
            
            keepGoing = inputReader.nextLine();

            if(depthDivedInFt >= 20000){
                System.out.println("Uhhh, I think I see a Kraken, guys ....");
                System.out.println("TIME TO GO!");
                break;
            }  
 }
            else if (keepGoing.equals("n")){
                System.out.println("Alright, let's resurface!");
                break;
                
            }
    }
        System.out.println("");
        System.out.println("We ended up swimming " + depthDivedInFt + " feet down.");
        System.out.println("I bet we can do better next time!");
    }
    
}
