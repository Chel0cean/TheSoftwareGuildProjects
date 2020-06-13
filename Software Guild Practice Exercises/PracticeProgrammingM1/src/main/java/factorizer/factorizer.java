
package factorizer;
import java.util.Scanner;
/**
 *
 * @author chelseamiller
 */
public class factorizer {
 public void factorizer(){   
     int num=0;
     int factorCount =0;
     int sum = 0;
     Scanner inputReader = new Scanner(System.in);
     System.out.println("What number would you like to factorize?");
     num = Integer.parseInt(inputReader.nextLine());
     System.out.println("The factors of "+num+" are:");
     for(int i=1; i<num; i++){
         if(num % i ==0){
             sum+=i;
             System.out.println(i);
             factorCount++;    
         }
         
     }
     System.out.println(num+" has "+factorCount+" factors.");
     if(sum==num){
                 System.out.println(num+" is a perfect number.");
             }else{
                  System.out.println(num+" is not a perfect number.");
             }
     if(sum==1){
          System.out.println(num+" is a prime number.");
             }else{
                  System.out.println(num+" is not a prime number.");
             }
     }
     
 }
 
