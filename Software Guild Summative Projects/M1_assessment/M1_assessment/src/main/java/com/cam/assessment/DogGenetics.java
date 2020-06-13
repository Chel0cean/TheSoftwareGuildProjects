package com.cam.assessment;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author chelseamiller
 */
public class DogGenetics {

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        Random randomizer = new Random();
        String dogName;
        int highestPercent = 101;
        String[] dogBreed = {"St. Bernard", "Chihuahua", "Dramatic RedNosed Asian Pug", "Common Cur", "King Doberman"};
        System.out.println("What is the name of your dog?");
        dogName = inputReader.nextLine();
        System.out.println("Well then, I have this highly reliable report on " + dogName + "'s prestigious background right here.");
        System.out.println(dogName + " is:");
        for (int i = 0; i < 5; i++) {
            int dogPercent = randomizer.nextInt((highestPercent - 1) + 1);
            highestPercent = highestPercent - dogPercent;
            System.out.println(dogPercent + "% " + dogBreed[i]);

        }
        System.out.println("Wow, that's QUITE the dog!");
    }
}
