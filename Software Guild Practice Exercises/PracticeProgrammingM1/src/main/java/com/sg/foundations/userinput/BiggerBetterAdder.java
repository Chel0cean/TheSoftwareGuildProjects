/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.userinput;
import java.util.Scanner;
/**
 *
 * @author chelseamiller
 */
public class BiggerBetterAdder {
 public static void main(String[] args) {
        int value1, value2, value3;
        int sum;
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Please give me a first value: ");
        value1 = Integer.parseInt(inputReader.nextLine());
        
        System.out.println("Please give me a second value: ");
        value2 = Integer.parseInt(inputReader.nextLine());
        
        System.out.println("Please give me a third value: ");
        value3 = Integer.parseInt(inputReader.nextLine());
   sum = value1+ + value2 + value3;
   System.out.println((value1) + " + " + (value2)  + " + " + (value3)  + " = " + (sum));
    }   
}
