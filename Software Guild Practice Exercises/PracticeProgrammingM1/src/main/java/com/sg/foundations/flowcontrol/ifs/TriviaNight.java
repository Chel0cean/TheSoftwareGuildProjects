
package com.sg.foundations.flowcontrol.ifs;
import java.util.Scanner;
/**
 *
 * @author chelseamiller
 */
public class TriviaNight {
  public static void main(String[] args){
     int capital, president, lightbulb;
     int score = 0;
      
      Scanner inputReader = new Scanner(System.in);
      System.out.println("Welcome to trivia night!");
      System.out.println("For each question, type the number corresponding with your answer.");
      System.out.println("Here's question one out of three:");
      System.out.println("What's the state capital of Texas?");
      System.out.println("1. Houston        2. Dallas");
      System.out.println("3. Austin         4. Paris");
      capital = Integer.parseInt(inputReader.nextLine());
      if (capital == 3) {
          score++;
          System.out.println("Correct! Your score is "+score+ "!");
      } else{
          System.out.println("Incorrect. Austin is the capital of Texas. Your score is " + score);
      }
      System.out.println("You have two questions left!");
      System.out.println("Who was the 42nd president of the United States?");
      System.out.println("1. George W. Bush        2. Bill Clinton");
      System.out.println("3. Henry Winkler         4. Barack Obama");
      president = Integer.parseInt(inputReader.nextLine());
      if (president == 2) {
          score++;
          System.out.println("Correct! Your score is "+score+ "!");
      }else{
          System.out.println("Incorrect. Bill Clinton was the 42nd president of the United States. Your score is " + score);
      }
      System.out.println("You have one question left!");
      System.out.println("What year was the lightbulb invented?");
      System.out.println("1. 1914        2. 1832");
      System.out.println("3. 1767        4. 1879");
      lightbulb = Integer.parseInt(inputReader.nextLine());
      if (lightbulb == 4) {
          score++;
          System.out.println("Correct! Your score is "+score+ "!");
      }else{
          System.out.println("Incorrect. The lightbulb was invented in 1879. Your score is " + score);
      }
      if(score >= 2){
       System.out.println("Well done! you scored " + score+"/3. You really know your trivia!");
      }
      else{
          System.out.println("Well, you tried. Hopefully you learned some facts! You scored "+score+"/3.");
      }
      
      
  }  
}
