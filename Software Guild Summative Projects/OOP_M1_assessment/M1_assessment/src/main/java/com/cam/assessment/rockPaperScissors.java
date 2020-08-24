package com.cam.assessment;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author chelseamiller
 */

public class rockPaperScissors {

    public void runProgram() {
        String answer = "y";
        Scanner inputReader = new Scanner(System.in);
        
        do {
            int rounds = 0;
            int userChoice = 0;
            int userWin = 0;
            int comWin = 0;
            int tie = 0;
            
            System.out.println("How many rounds of rock paper scissors would you like to play? (1-10):");
            rounds = Integer.parseInt(inputReader.nextLine());
            
            if (check(rounds) == true) {
                for (int i = 0; i < rounds; i++) {
                    System.out.println("Round " + (i + 1) + ":");
                    System.out.println("Make your choice: Rock(1), Paper(2), or Scissors(3):");
                    userChoice = Integer.parseInt(inputReader.nextLine());
                    String result = gamePlay(userChoice);
                    System.out.println(result);
                    System.out.println();

                    if (result.equals("Computer wins this round!")) {
                        comWin++;

                    }
                    if (result.equals("You won this round!")) {
                        userWin++;

                    }
                    if (result.equals("This round is a tie!")) {
                        tie++;

                    }

                }

                System.out.println("Computer wins: " + comWin);
                System.out.println("User wins: " + userWin);
                System.out.println("Ties: " + tie);
                if (comWin < userWin && userWin >= tie) {
                    System.out.println("You're the overall winner!!");
                }
                if (comWin > userWin && comWin >= tie) {
                    System.out.println("The computer is the winner overall!!");
                }
                if (tie > comWin || tie > userWin || userWin == comWin) {
                    System.out.println("It's a tie overall!");
                }
                System.out.println("Would you like to play again? (y/n)");
                answer = inputReader.nextLine();

            } else {
                System.out.println("Sorry, that's not an acceptable amount of rounds!");
            }
        } while (answer.equals("y"));

    }

    public static boolean check(int x) {
        return x >= 1 && x <= 10;

    }

    public static String gamePlay(int n) {
        Random randomizer = new Random();
        int comChoice;

        comChoice = randomizer.nextInt((3 - 1) + 1);

        //user chooses rock
        if (n == 1 && comChoice == 2) {
            return "Computer wins this round!";

        }
        if (n == 1 && comChoice == 3) {
            return "You won this round!";
        }
        //user chooses paper
        if (n == 2 && comChoice == 1) {
            return "You won this round!";

        }
        if (n == 2 && comChoice == 3) {
            return "Computer wins this round!";
        }
        //user chooses scissors
        if (n == 3 && comChoice == 1) {
            return "Computer wins this round!";
        }
        if (n == 3 && comChoice == 2) {
            return "You won this round!";

        } //both choose the same thing
        else {
            return "This round is a tie!";
        }

    }
}
