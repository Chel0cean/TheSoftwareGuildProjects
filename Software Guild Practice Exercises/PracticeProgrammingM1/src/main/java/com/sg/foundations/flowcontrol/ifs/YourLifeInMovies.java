
package com.sg.foundations.flowcontrol.ifs;
import java.util.Scanner;
/**
 *
 * If they were born before 2005, print out that Pixar's 'Up' came out over a decade ago.
If they were born before 1995, print out that the first Harry Potter came out over 15 years ago.
If they were born before 1985, print out Space Jam came out not last decade, but the one before THAT.
If they were born before 1975, print out that the original Jurassic Park release is closer to the first lunar landing than it is to today.
If they were born before 1965, print out that the MASH TV series has been around for almost half a century!
 * @author chelseamiller
 */
public class YourLifeInMovies {
    public static void main(String[] args){
    int birthYear = 0;
    Scanner inputReader = new Scanner(System.in);
System.out.println("What year were you born?"); 
birthYear = Integer.parseInt(inputReader.nextLine());
System.out.println("Did you know: ");

if (birthYear < 2005) {
     System.out.println("* Pixar's 'Up' came out over a decade ago.");
if (birthYear < 1995) {
     System.out.println("* The first Harry Potter came out over 15 years ago.");
if (birthYear < 1985) {
    System.out.println("* Space Jam came out not last decade, but the one before THAT.");
if (birthYear < 1975){
   System.out.println("* The original Jurassic Park release is closer to the first lunar landing than it is to today.");
if(birthYear < 1965){
  System.out.println("* The MASH TV series has been around for almost half a century!");   
}
}
}
}
}
    }
    
}
