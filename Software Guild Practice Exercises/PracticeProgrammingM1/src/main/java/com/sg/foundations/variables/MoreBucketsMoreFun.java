package com.sg.foundations.variables;




/**
 *
 * @author chelseamiller
 */
public class MoreBucketsMoreFun {
    public static void main(String[] args) {
        int butterflies, beetles, bugs;
        butterflies = 5;
        beetles = 9;
        bugs = butterflies + beetles;
        System.out.println("There are only " + butterflies + " butterflies");
        System.out.println("but there are " + bugs + " bugs in all");
        
        System.out.println("Uh oh, my dog ate one.");
        butterflies--;
        System.out.println("Now there are only " + butterflies + " butterflies");
        System.out.println("But there are still " + bugs + " bugs left");
        System.out.println("Wait a minute!");
        System.out.println("...maybe my computer can't do math, after all!");
    }
    
}
