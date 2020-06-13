
package com.sg.foundations.flowcontrol.whiles;
import java.util.Random;
/**
 *
 * @author chelseamiller
 */
public class LazyTeenager {
 public static void main(String[] args){
     Random randomizer = new Random();
     int countmax = randomizer.nextInt((8-1)+1);
     int count = 0;
     do{
     count++;
     System.out.println("Clean your room!!" + "(X"+count+")");
     countmax--;
     
     } 
     while(countmax >0);
     if(count<7){
     System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
 }
     if(count ==7){
     System.out.println("Clean your room!! That's IT, I'm doing it!!! YOU'RE GROUNDED AND I'M TAKING YOUR XBOX!");
 }
}
}