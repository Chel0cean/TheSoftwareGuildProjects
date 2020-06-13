
package com.sg.foundations.userinput;
import java.util.Scanner;
/**
 *
 * @author chelseamiller
 */
public class MiniMadLibs {
 public static void main(String[] args){
     String noun, adj, noun2, adj2, plNoun, plNoun2, plNoun3, verbPresent, verbPast;
     int number;
     Scanner inputReader = new Scanner(System.in);
     System.out.println("I need a noun: ");
     noun = inputReader.nextLine();
     System.out.println("Now an adjective: ");
     adj = inputReader.nextLine();
     System.out.println("Another noun: ");
     noun2 = inputReader.nextLine();
     System.out.println("A number:");
     number = Integer.parseInt(inputReader.nextLine());
     System.out.println("Another adjective: ");
     adj2 = inputReader.nextLine();
     System.out.println("A plural noun: ");
     plNoun = inputReader.nextLine();
     System.out.println("Another plural noun: ");
     plNoun2 = inputReader.nextLine();
     System.out.println("One more plural noun: ");
     plNoun3 = inputReader.nextLine();
     System.out.println("A verb (present tense): ");
     verbPresent = inputReader.nextLine(); 
     System.out.println("Same verb but past tense: ");
     verbPast = inputReader.nextLine();
     System.out.println("*** NOW LETS GET MAD (libs) ***");
     System.out.println(noun + ": the "+ adj +" frontier. These are the voyages of the starship " + noun2 + ". ");
     System.out.println("Its " + number + "-year mission: to explore strange " + adj2 + " " + plNoun + ", to seek out " + adj2 +" " + plNoun2); 
     System.out.println(" and " + adj2 + " " + plNoun3 + ", to boldly " + verbPresent +" where no one has " + verbPast + " before.");
            
 }   
}
