package lesson5ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author chelseamiller
 */
public class StudentQuizGrades {

    public static void main(String[] args) {
        String returnToMain;
        String student = "";
        int answer = 0;
        int highScore = 0; 
        int lowScore = 100;
  
        
        Scanner inputReader = new Scanner(System.in);
        UserIO userIO = new UserIoClassLab();
        HashMap<String, ArrayList<Integer>> studentGrades = new HashMap<>();

        while (!(answer >= 1 && answer <= 5)) {

            int total = 0;
            int count = 0;
            userIO.print("Hello, please choose one of the options below by typing in the corresponding number:");
            userIO.print("1. View all students.");
            userIO.print("2. Add a new student.");
            userIO.print("3. Remove a student.");
            userIO.print("4. View a list of quiz scores for a given student.");
            userIO.print("5. View the average score for a given student.");
            userIO.print("6. See the average quiz score for the entire class.");
            userIO.print("7. List the student with the highest score.");
            answer = userIO.readInt("8. list the student with the lowest score.");

            studentGrades.put("Abigail", new ArrayList<Integer>(Arrays.asList(65, 73, 79, 87, 96)));
            studentGrades.put("Nicolas", new ArrayList<Integer>(Arrays.asList(77, 53, 81, 99, 75)));
            studentGrades.put("Kim", new ArrayList<Integer>(Arrays.asList(55, 58, 64, 82, 90)));
            studentGrades.put("Jade", new ArrayList<Integer>(Arrays.asList(88, 83, 89, 86, 90)));
            studentGrades.put("Philip", new ArrayList<Integer>(Arrays.asList(76, 73, 77, 98, 95)));
            studentGrades.put("Mark", new ArrayList<Integer>(Arrays.asList(62, 78, 71, 75, 82)));
            studentGrades.put("Rigel", new ArrayList<Integer>(Arrays.asList(91, 95, 89, 85, 94)));
            studentGrades.put("Anna", new ArrayList<Integer>(Arrays.asList(51, 80, 82, 88, 93)));
            studentGrades.put("Jonathan", new ArrayList<Integer>(Arrays.asList(81, 55, 65, 83, 79)));
            studentGrades.put("Ashley", new ArrayList<Integer>(Arrays.asList(79, 69, 89, 90, 84)));

            Set<String> keys = studentGrades.keySet();

            if (answer == 1) {
                userIO.print("Students:");
                userIO.print("=======");
                for (String k : keys) {
                    userIO.print(k);

                }
                returnToMain = userIO.readString("Would you like to return to the main menu? (y/n)");
                if (returnToMain.equals("y")) {
                    answer = 0;
                }

            }

            if (answer == 2) {
                student = userIO.readString("What is the student's name that you would like to add?");
                studentGrades.put(student, new ArrayList<>());
                userIO.print(student + " has been added.");
                returnToMain = userIO.readString("Would you like to return to the main menu? (y/n)");
                if (returnToMain.equals("y")) {
                    answer = 0;
                }

            }

            if (answer == 3) {
                student = userIO.readString("Which student would you like to remove?");
                studentGrades.remove(student);
                userIO.print(student + " has been removed.");
                returnToMain = userIO.readString("Would you like to return to the main menu? (y/n)");
                if (returnToMain.equals("y")) {
                    answer = 0;
                }

            }

            if (answer == 4) {
                student = userIO.readString("Which student's scores would you like to see?");
                userIO.print(student + "'s scores are:");
                System.out.println(studentGrades.get(student));
                returnToMain = userIO.readString("Would you like to return to the main menu? (y/n)");
                if (returnToMain.equals("y")) {
                    answer = 0;
                }

            }

            if (answer == 5) {
                student = userIO.readString("Which student's scores would you like to average?");
                ArrayList<Integer> scores = studentGrades.get(student);
                for (int k : scores) {
                    total += k;
                    count++;

                }
                userIO.print("The average of " + student + "'s scores is: " + (total / count));
                returnToMain = userIO.readString("Would you like to return to the main menu? (y/n)");
                if (returnToMain.equals("y")) {
                    answer = 0;
                }

            }
            if (answer == 6) {
                for (String j : keys) {
                    ArrayList<Integer> scores = studentGrades.get(j);
                    for (int k : scores) {
                        total += k;
                        count++;

                    }

                }
                userIO.print("the class average is " + (total / count));
                returnToMain = userIO.readString("Would you like to return to the main menu? (y/n)");
                if (returnToMain.equals("y")) {
                    answer = 0;
                }

            }
            if (answer == 7) {
                for (String j : keys) {
                    ArrayList<Integer> scores = studentGrades.get(j);
                    for (int k : scores) {
                        if(k> highScore){
                            highScore = k;
                            student=j;
                        }

                    }

                }
                userIO.print("The student with the highest score of "+highScore+" is "+student);
                
                returnToMain = userIO.readString("Would you like to return to the main menu? (y/n)");
                if (returnToMain.equals("y")) {
                    answer = 0;
                }

            }
            if (answer == 8) {
               for (String j : keys) {
                    ArrayList<Integer> scores = studentGrades.get(j);
                    for (int k : scores) {
                        if(k<lowScore){
                            lowScore = k;
                            student=j;
                        }

                    }

                }
                userIO.print("The student with the lowest score of "+lowScore+" is "+student);
                returnToMain = userIO.readString("Would you like to return to the main menu? (y/n)");
                if (returnToMain.equals("y")) {
                    answer = 0;
                }

            } else {
                userIO.print(answer + " is not a valid entry.");
            }
        }
    }
}
