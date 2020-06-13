
package com.sg.foundations.flowcontrol.whiles;

/**
 *
 * @author chelseamiller
 */
public class LovesMe {
    public static void main(String[] args) {
      int petals = 34;
      String prediction = "";
      
      System.out.println("Well here goes nothing...");
    
while (petals > 0) {
  if(petals %2 == 0) { 
      prediction = "It loves me NOT!";
       System.out.println(prediction);
       petals--;}
    
  if(petals % 2 != 0) {
         prediction = "It LOVES me!";
       System.out.println(prediction); 
       petals--;
     
      } 
                  
   } 
  if (petals == 0) {
    System.out.println("I knew it! " + prediction);
 }
       
        
    
   
}
}
