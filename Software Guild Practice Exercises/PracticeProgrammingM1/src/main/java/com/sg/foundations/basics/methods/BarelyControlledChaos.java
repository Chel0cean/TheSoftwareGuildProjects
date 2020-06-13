package com.sg.foundations.basics.methods;



import java.util.Random;
/**
 *
 * @author chelseamiller
 */
public class BarelyControlledChaos {
    public static void main(String[] args) {

        String color = color(); 
        String animal = animal(); 
        String colorAgain = color(); 
        int weight = number(5, 20); 
            // with a range between 5 - 200
        int distance = number(10, 20); 
            // with a range between 10 - 20
        int number = number(10000, 20000); 
            // with a range between 10000 - 20000
        int time = number(2, 6);
            // with a range between 2 - 6            

        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
            + weight + "lb " + " miniature " + animal
            + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over "
            + number + " " + colorAgain + " poppies for nearly "
            + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, "
            + "let me tell you!");
    }

    public static String color(){
     Random randomizer = new Random();
     int value = randomizer.nextInt((5 - 1 + 1) +1);
     if(value == 1){
         return "blue";
     }
     if(value == 2){
         return "yellow";
     }
     if (value == 3){
         return "green";
     }
     if (value == 4){
         return "red"; 
     }
     if (value == 5){
         return "purple";
     }
     else{
         return "";
     }
    }
    
    public static String animal() {
     Random randomizer = new Random(); 
      int value = randomizer.nextInt((5 - 1 + 1) +1);
     if(value == 1){
         return "Zebra";
     }
     if(value == 2){
         return "Cow";
     }
     if (value == 3){
         return "Lion";
     }
     if (value == 4){
         return "Monkey"; 
     }
     if (value == 5){
         return "Cat";
     }
     else{
         return "";
    }
    }
    
    public static int number(int min, int max) 
    {
    Random randomizer = new Random();
    int value = (randomizer.nextInt((max - min)+ min));
    return value;
    }

 }