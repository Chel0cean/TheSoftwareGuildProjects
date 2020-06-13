
package com.sg.foundations.flowcontrol.fors;
import java.util.Scanner;
/**
 *
 * @author chelseamiller
 */
public class ForTimesFor {
    public static void main(String[] args ){
        int count, X, guess;
        double score = 0;
        
  Scanner inputReader = new Scanner(System.in);
  System.out.println("Which times table should I recite? ");
  count = Integer.parseInt(inputReader.nextLine());
  for(int i=1; i<=15; i++){
      X = i * count;
      System.out.println(i + " * " +count + " is: ");
      guess = Integer.parseInt(inputReader.nextLine());
      if(guess==X){
          System.out.println("Correct!");
      score = score + 6.67;
      }
      else{
          System.out.println("Sorry no, the answer is: "+ X);
      }
  }
  if (score <= 50){
      System.out.println("You scored "+ score+ "%. You should study more.");
  }
      if (score > 90){
          System.out.println("You scored "+score+"%. Congrats! You really know your multiples!");
      }
          else{
                  System.out.println("You scored "+score+"%.");
                  }
      }
  }

    

