
package com.sg.foundations.flowcontrol.fors;
import java.util.Scanner;
/**
 *
 * @author chelseamiller
 */
public class TheCount {
  public static void main(String[] args){
      int startValue, endValue, count;
      int counter = 0;
      Scanner inputReader = new Scanner(System.in);
     System.out.println("*** I LOVE TO COUNT! LET ME SHARE MY COUNTING WITH YOU! ***");
     System.out.println("Start at : ");
     startValue = Integer.parseInt(inputReader.nextLine());
     System.out.println("End at: ");
     endValue = Integer.parseInt(inputReader.nextLine());
     System.out.println("Count by: ");
     count = Integer.parseInt(inputReader.nextLine());
     for(int i = startValue; i<=endValue; i+=count){
         counter ++;
     System.out.print(i +" ");
     if(counter % 3 == 0){
         System.out.println("- Ah ah ah!");
     }
     }
     }
  }  

