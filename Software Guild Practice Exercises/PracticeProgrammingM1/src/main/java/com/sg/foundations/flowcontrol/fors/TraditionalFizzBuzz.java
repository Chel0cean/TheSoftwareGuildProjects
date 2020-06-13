
package com.sg.foundations.flowcontrol.fors;
import java.util.Scanner;
/**
 *
 * @author chelseamiller
 */
public class TraditionalFizzBuzz {
  public static void main(String[] args){
      Scanner userInput = new Scanner(System.in);
      int count;
   System.out.println("How many units of fizzing and buzzing do you need in your life?");   
    count = userInput.nextInt();
    System.out.println("___________________");
    for(int i =0; i<=count; i++){
        
        if(i % 3 == 0 && i % 5 != 0 && i > 0){
         System.out.println("fizz");
         
        }
        if(i % 5 == 0 && i % 3 != 0 && i > 0){
         System.out.println("buzz");   
         
        }
        if(i % 3 == 0 && i % 5 == 0 && i > 0){
         System.out.println("fizz buzz");   
        }
        if(i % 3 != 0 && i % 5 != 0 && i >= 0) {
           System.out.println(i); 
        }
    } 
    System.out.println("TRADITION!!!!!");
    
}  
}
