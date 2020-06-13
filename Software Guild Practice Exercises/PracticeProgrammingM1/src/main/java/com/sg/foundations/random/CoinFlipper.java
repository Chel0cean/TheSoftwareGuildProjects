
package com.sg.foundations.random;
import java.util.Random;

/**
 *
 * @author chelseamiller
 */
public class CoinFlipper {
    public static void main(String[] args){
        
     Random randomizer = new Random();
     
     System.out.println(">Ready, Set, Flip....!!");
     boolean coin = randomizer.nextBoolean();
     if(coin == true){
     System.out.println("You got TAILS!");
     }
     if(coin == false){
     System.out.println("You got HEADS!");
     }
    }
}
