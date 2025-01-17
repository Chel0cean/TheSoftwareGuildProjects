/*********************************
* The Software Guild
* Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
*********************************/
package com.tsg.unittesting.logic;

/**
 *
 * @author ahill
 */
public class LogicExerciseE {

    /**
     * Given the following chart, return the correct color designation 
     * given measured wavelength, frequency and photonic energy. 
     * If it doesn't fall within correct bands, return "Unknown" instead. 
     * If it falls exactly within a band transition, 
     * return a compound color, with the longer wavelength color first. 
     * 
     * 	Color	Wavelength	Frequency	Photon energy
     * 	Violet	380–450 nm	668–789 THz	2.75–3.26 eV
     * 	Blue	450–495 nm	606–668 THz	2.50–2.75 eV
     * 	Green	495–570 nm	526–606 THz	2.17–2.50 eV
     * 	Yellow	570–590 nm	508–526 THz	2.10–2.17 eV
     * 	Orange	590–620 nm	484–508 THz	2.00–2.10 eV
     * 	Red	620–750 nm	400–484 THz	1.65–2.00 eV
     *
     * Ex:
     * whatColor( 575, 510, 2.15 ) ->  "Yellow"
     * whatColor( 449, 670, 3.00 ) ->  "Violet"
     * whatColor( 621, 475, 16.5 ) ->  "Unknown"
     * whatColor( 590, 508, 2.05 ) ->  "Orange"
     * whatColor( 570, 526, 2.17 ) ->  "Yellow-Green"
     * @param waveLengthNM
     * @param frequencyTHZ
     * @param photonicEnergyEV
     * @return String color
     */
    public static String whatColor(int waveLengthNM, int frequencyTHZ, double photonicEnergyEV) {
        String color="";
       if(waveLengthNM>=620 && waveLengthNM<=750 && frequencyTHZ >= 400 && frequencyTHZ <=484 && photonicEnergyEV >=1.65 && photonicEnergyEV <= 2.00){
           color="Red";
       }
       if(waveLengthNM>=590 && waveLengthNM<=620 && frequencyTHZ >= 484 && frequencyTHZ <=508 && photonicEnergyEV >=2.00 && photonicEnergyEV <= 2.10){
           if (!"".equals(color)){
               color+="-Orange";
           }else{
               color = "Orange";
           }
       }
       if(waveLengthNM>=570 && waveLengthNM<=590 && frequencyTHZ >= 508 && frequencyTHZ <=526 && photonicEnergyEV >=2.10 && photonicEnergyEV <= 2.17){
           if (!"".equals(color)){
               color+="-Yellow";
           }else{
               color = "Yellow";
           }
       }
       
       if(waveLengthNM>=450 && waveLengthNM<=495 && frequencyTHZ >= 606 && frequencyTHZ <=668 && photonicEnergyEV >=2.50 && photonicEnergyEV <= 2.75){
           if (!"".equals(color)){
               color+="-Blue";
           }else{
               color = "Blue";
           }
       }
       if(waveLengthNM>=495 && waveLengthNM<=570 && frequencyTHZ >= 526 && frequencyTHZ <=606 && photonicEnergyEV >=2.17 && photonicEnergyEV <= 2.50){
           if (!"".equals(color)){
               color+="-Green";
           }else{
               color = "Green";
           }
           
       }
       if(waveLengthNM>=380 && waveLengthNM<=450 && frequencyTHZ >= 668 && frequencyTHZ <=789 && photonicEnergyEV >=2.75 && photonicEnergyEV <= 3.26){
           if (!"".equals(color)){
               color+="-Violet";
           }else{
               color = "Violet";
           }
        
       }
       if("".equals(color)){
        color="Unknown";   
       }
       return color;
    }

}
