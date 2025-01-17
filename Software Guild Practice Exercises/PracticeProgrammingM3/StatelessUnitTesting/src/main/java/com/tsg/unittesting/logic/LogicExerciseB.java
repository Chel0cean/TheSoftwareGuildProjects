/*********************************
* The Software Guild
* Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
*********************************/
package com.tsg.unittesting.logic;

/**
 *
 * @author ahill
 */
public class LogicExerciseB {

    /**
     * Given a number, return the 'place rank' word associated with it.
     * I.e. pretend you're ranking folks running in a race from the order they
     * arrived at the finish line. Assume nonzero, positive inputs! 
     * Also, start by going up to 100, but stretch to more if you can!
     *
     * Ex:
     * placeOf( 1 ) ->   "1st"
     * placeOf( 3 ) ->   "3rd"
     * placeOf( 22 ) ->   "22nd"
     *
     * @param place
     * @return String
     */
    public String placeOf(int place) {
        String placeCon="";
     if(place%10==1 && place !=11){
         placeCon=Integer.toString(place);
         return placeCon+"st";
     }
     if(place%10==2 && place !=12){
         placeCon=Integer.toString(place);
        return placeCon+"nd"; 
     }
     if(place%10==3 && place !=13){
         placeCon=Integer.toString(place);
        return placeCon+"rd"; 
     }
     else{
         placeCon=Integer.toString(place);
         return placeCon+"th";
     }
    }

}
