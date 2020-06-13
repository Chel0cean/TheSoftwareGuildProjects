package com.sg.foundations.basics.arrays;



import java.util.Random;
/**
 *
 * @author chelseamiller
 */
public class HiddenNuts {
   public static void main(String[] args) {

        String[] hidingSpots = new String[100];
        Random squirrel = new Random();
        int spot = squirrel.nextInt(hidingSpots.length);
        hidingSpots[spot] = "Nut";
        System.out.println("The nut has been hidden ...");
       System.out.println("Found it! it's in spot # " + spot);
           
            
            
        }
       
    } 

