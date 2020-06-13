
package com.sg.foundations.variables;

/**
 *
 * @author chelseamiller
 */
public class MenuOfChampions {
public static void main(String[] args) {
 String name, item1name, item2name, item3name;
 float item1cost, item2cost, item3cost;
 
 name = "Chelsea's Diner";
 item1name = " Quesadilla";
 item2name = " Lasagna";
 item3name = " Cheesecake";
 item1cost = 10.50f;
 item2cost = 17.25f;
 item3cost = 9.75f;       
 
 System.out.println("Welcome to " + name +"!");
 System.out.println("Today's menu is...");
 
 System.out.println("* - * - * - * - * - * - * - * - * - * - * - * - * - * - * - *");
 System.out.println("$" + item1cost + "....." + item1name);
 System.out.println("$" + item2cost + "....." + item2name);
 System.out.println("$" + item3cost + "....." + item3name);
}    
}
