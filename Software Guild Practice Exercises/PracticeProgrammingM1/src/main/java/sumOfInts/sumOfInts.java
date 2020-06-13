
package sumOfInts;
import java.util.Scanner;

/**
 *
 * @author chelseamiller
 */
public class sumOfInts {
 public static void main(String[] args){
     int userInput, input2;
     
     
     Scanner inputReader = new Scanner(System.in);
    do{
        int sum = 0;
     System.out.println("Please enter a positive integer:");
     userInput = Integer.parseInt(inputReader.nextLine());
     System.out.println("You've entered "+userInput);
     if(userInput <0){
         System.out.println("Goodbye");
         System.exit(0);
     }
    
   while(userInput > 0) { 
        
        sum = sum + (userInput%10);
        userInput = userInput / 10;
   }
     
    System.out.println("the sum of those digits is "+ sum);
     
    } while(true);
 }
}
