
package com.sg.foundations.flowcontrol.ifs;
import java.util.Scanner;
/**
 *
 * @author chelseamiller
 */
public class BirthStones {
public static void main(String[] args){
    Scanner inputReader = new Scanner(System.in);
    System.out.println("");
    int birthMonth=0;
    System.out.println("What is your birth month number? (January=1, February=2, etc...)");
    birthMonth = Integer.parseInt(inputReader.nextLine());
    if(birthMonth == 1){
   System.out.println("The birthstone for January is Garnet");
    }
    if(birthMonth == 2){
   System.out.println("The birthstone for February is Amethyst.");
    }
    if(birthMonth == 3){
   System.out.println("The birthstone for March is Aquamarine.");
    }
    if(birthMonth == 4){
   System.out.println("The birthstone for April is Diamond.");
    }
    if(birthMonth == 5){
   System.out.println("The birthstone for May is Emerald.");
    }
    if(birthMonth == 6){
   System.out.println("The birthstone for June is Pearl.");
    }
    if(birthMonth == 7){
   System.out.println("The birthstone for July is Ruby.");
    }
    if(birthMonth == 8){
   System.out.println("The birthstone for August is Peridot.");
    }
    if(birthMonth == 9){
   System.out.println("The birthstone for September is Sapphire.");
    }
    if(birthMonth == 10){
   System.out.println("The birthstone for October is Opal.");
    }
    if(birthMonth == 11){
   System.out.println("The birthstone for November is Topaz.");
    }
    if(birthMonth == 12){
   System.out.println("The birthstone for December is Turquoise.");
    }
    if(birthMonth < 1 || birthMonth > 12){
   System.out.println("I think you must be confused, " + birthMonth + " doesn't match a month.");
    }
    }
    
}   
