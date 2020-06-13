/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.flowcontrol.ifs;
import java.util.Scanner;
/**
 *
 * @author chelseamiller
 */
public class FieldDay {
    public static void main(String[] args){
        Scanner inputReader = new Scanner(System.in);
        String lastName;
        String n1 = "baggins";
        String n2 = "dresden";
        String n3 = "howl";
        String n4 = "potter";
        String n5 = "vimes";
        String team = "fail";
        
        System.out.println("What's your last name? ");
        lastName = inputReader.nextLine();
        int t1 = lastName.compareTo(n1);
        int t2 = lastName.compareTo(n2);
        int t3 = lastName.compareTo(n3);
        int t4 = lastName.compareTo(n4);
        int t5 = lastName.compareTo(n5);
        
        if(t1 < 0){
        team = "Red Dragons"; 
        }
        if(t2 < 0 && t1 > 0 ){
        team = "Dark Wizards";  
        }
        if(t3 < 0 && t2 > 0 ){
        team = "Moving Castles";
        }
        if(t4 < 0 && t3 > 0 ){
         team = "Golden Snitches";  
        }
        if(t5 < 0 && t4 > 0){
         team = "Night Guards";   
        }
        if (t5 > 0){
         team = "Black Holes";   
        }
        System.out.println("Aha! You're on the team " + team);

    }
}
