
package com.sg.foundations.random;
import java.util.Random;
/**
 *
 * @author chelseamiller
 */
public class FortuneCookie {
 public static void main(String[] args){
  Random randomizer = new Random();  
  int x = randomizer.nextInt(11);
  if(x == 1){
  System.out.println(">Your Geek Fortune: Those aren't the droids you're looking for.");
  }
  if(x == 2){
  System.out.println(">Your Geek Fortune: Never go in against a Sicilian when death is on the line!");
  }
  if(x == 3){
  System.out.println(">Your Geek Fortune: Goonies never say die.");
  }
  if(x == 4){
  System.out.println(">Your Geek Fortune: With great power, there must also come — great responsibility.");
  }
  if(x == 5){
  System.out.println(">Your Geek Fortune: Never argue with the data.");
  }
  if(x == 6){
  System.out.println(">Your Geek Fortune: Try not. Do, or do not. There is no try.");
  }
  if(x == 7){
  System.out.println(">Your Geek Fortune: You are a leaf on the wind, watch how you soar.");
  }
  if(x == 8){
  System.out.println(">Your Geek Fortune: Do absolutely nothing, and it will be everything that you thought it could be.");
  }
  if(x == 9){
  System.out.println(">Your Geek Fortune: Kneel before Zod.");
  }
  if(x == 10){
  System.out.println(">Your Geek Fortune: Make it so.");
  }
 
 }   
}
