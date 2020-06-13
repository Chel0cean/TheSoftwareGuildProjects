
package com.sg.foundations.flowcontrol.whiles;
import java.util.Random;

/**
 *
 * @author chelseamiller
 */
public class MaybeItLovesMe {
    public static void main(String[] args) {
     
      String prediction = "";
   Random randomizer = new Random();
   int petalCount = 1;
   int yN = 0;
     int petals = randomizer.nextInt((90-12) + 12);
     System.out.println("Well here goes nothing...");
    
while (petals > 0) {
        if(petalCount % 2 == 0 && petals>0){
      prediction = "It loves me NOT!"; 
      yN = 1;
       petals--;
       petalCount++;
        System.out.println(prediction);
        }
       
        if (petalCount % 2 != 0 && petals>0) {
            yN = 2;
       prediction = "It LOVES me!"; 
       petals--;
       petalCount++;
        System.out.println(prediction);
        }       
 }
        if (yN == 2) {
        System.out.println("Oh, wow! It really LOVES me!");
        }
        if (yN == 1) {
        System.out.println("Awwww, bummer.");
        }

}
    
}
