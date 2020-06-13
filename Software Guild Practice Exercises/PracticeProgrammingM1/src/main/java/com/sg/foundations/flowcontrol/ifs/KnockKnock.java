
package com.sg.foundations.flowcontrol.ifs;
import java.util.Scanner;
/**
 *
 * @author chelseamiller
 */
public class KnockKnock {
    public static void main(String[] args){
     Scanner inputReader = new Scanner(System.in);

        System.out.println("Knock Knock! Guess who!! ");
        String nameGuess = inputReader.nextLine();
//If you try equal signs here it just defaults to the else statement, same if the capitalization is wrong. 
        if(nameGuess.equals("Marty McFly")){
            System.out.println("Hey! That's right! I'm back!");
            System.out.println(".... from the Future."); // Sorry, had to!
        }else{
            System.out.println("Dude, do I -look- like " + nameGuess);
        }   
    }
    
}
