package com.cam.assessment;

import java.util.Scanner;

/**
 *
 * @author chelseamiller
 */
public class HealthyHearts {

    public static void main(String[] args) {

        double age, max, targetLow, targetHigh;

        Scanner inputReader = new Scanner(System.in);

        System.out.println("What is your age?");
        age = Double.parseDouble(inputReader.nextLine());
        max = 220 - age;
        targetLow = max * .5;
        targetHigh = max * .85;
        System.out.println("Your maximum heart rate should be " + max + " beats per minute.");
        System.out.println("Your target heart rate zone is " + targetLow + "-" + targetHigh + " beats per minute.");
    }
}
