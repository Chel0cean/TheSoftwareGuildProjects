/*********************************
* The Software Guild
* Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
*********************************/
package com.tsg.unittesting.arrays;

import java.text.DecimalFormat;

/**
 *
 * @author ahill
 */
public class ArrayExerciseD {
    
    /**
     * Given an array of doubles, return the biggest number of the lot, as if the decimal had gone missing!
     *
     * 
     * pointFree( [1.1, .22]  ) ->  22
     * pointFree( [ .039 , 20 , .005005 ]  ) ->  5005
     * pointFree( [ -9.9 , -700 , -.5  ]  ) ->  -5
     * 
     * @param numbers
     * @return
     */
    public static int pointFree(double[] numbers){
        String completeString = "";
        String redactedString = "";
        int newArray[] = new int[numbers.length];
        int greatestValue=0;
        
        
        
       for (double x : numbers) {
          int currentValue;
           
           completeString = String.valueOf(x);
           redactedString = completeString.replaceAll("\\.","");
           currentValue = Integer.parseInt(redactedString);
           for (int i = 0; i < newArray.length; i++) {
               
              newArray[i]=currentValue;
              
               
           }
          greatestValue=newArray[0];
           for (int i = 0; i < newArray.length; i++) {
               if(newArray[i]>greatestValue){
                   greatestValue=newArray[i];
               
           }
           
            }
        
            
        }
       return greatestValue;
        
    }
    
}
