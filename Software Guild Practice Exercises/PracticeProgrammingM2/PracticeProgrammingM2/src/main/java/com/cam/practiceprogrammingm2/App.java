
package com.cam.practiceprogrammingm2;
import java.util.Scanner;
/**
 *
 * @author chelseamiller
 */
public class App {
    public static void main(String[] args){
SimpleCalculator mySimpleCalculator = new SimpleCalculator();
 Scanner inputReader = new Scanner(System.in); 
 String operator;
 int operand1, operand2; 
 int answer = 0;
 do{
 System.out.println("Please enter an operator (+, -, *, /) or type 'exit':");
 operator = inputReader.nextLine();
 if (operator.equals("exit")){
     System.out.println("Thanks for using our calculator, Goodbye!");
     return;
 }else{
 System.out.println("Please enter your first operand:");
 operand1 = Integer.parseInt(inputReader.nextLine());
 System.out.println("Please enter your second operand:");
 operand2 = Integer.parseInt(inputReader.nextLine());
 
 
 if (operator.equals("+")){
   
        answer = mySimpleCalculator.sum(operand1, operand2);   
 }
 if (operator.equals("-")){
     answer = mySimpleCalculator.minus(operand1, operand2); 
 }
 if (operator.equals("*")){
  answer = mySimpleCalculator.multiply(operand1, operand2);    
 }
 if (operator.equals("/")){
    answer = mySimpleCalculator.divide(operand1, operand2); 
 }
 System.out.println(operand1+operator+operand2+" = " + answer);
 }
 } while(!(operator.equals("exit")));
    
    }
}
