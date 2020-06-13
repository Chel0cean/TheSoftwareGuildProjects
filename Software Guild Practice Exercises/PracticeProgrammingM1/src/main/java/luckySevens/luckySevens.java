
package luckySevens;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author chelseamiller
 */
public class luckySevens {
 public void playGame(){
  int startBet, bank, greatestWin;
  int rollCount = 0;
  int biggestRoll = 0;
  Scanner inputReader = new Scanner(System.in);
  System.out.println("How much money would you like to bet? ");
  startBet = Integer.parseInt(inputReader.nextLine());
  bank = startBet;
  greatestWin = startBet;
    do{
      rollDie();  
    rollCount++;
      if(rollDie() == 7){
   bank+=4; 
   
  }
  else{
      bank--;
  }
      if(bank > greatestWin){
          greatestWin = bank;
          biggestRoll = rollCount;
          
      }
      
    } while(bank > 0);
   System.out.println("You are broke after "+rollCount+ " rolls.");
   System.out.println("You should've stopped at roll " + biggestRoll + " when you had $"+greatestWin+".");
  
 } 
public static int rollDie(){
    Random randomizer = new Random();
 int die1, die2;
 die1 = randomizer.nextInt((6 - 1) + 1);
 die2 = randomizer.nextInt((6 - 1) + 1);
 int dieTotal = die1 + die2;
 return dieTotal;
} 
}
