
package lesson3;

import java.util.Scanner;

/**
 *
 * @author chelseamiller
 */
public class IntMath {
   public int calculate(IntEnum operator, int operand1, int operand2) {
         switch(operator) {
                case PLUS:
                      return operand1 + operand2;
                case MINUS:
                      return operand1 - operand2;
                case MULTIPLY:
                      return operand1 * operand2;
                case DIVIDE:
                      return operand1 / operand2;
                default:
                      throw new UnsupportedOperationException();
         }
   }
   public int getoperand1(){
    Scanner sc = new Scanner(System.in); 
     System.out.println("Please enter first operand");
     int operand1= Integer.parseInt(sc.nextLine());
     return operand1;   
   }
   public int getoperand2(){
    Scanner sc = new Scanner(System.in); 
     System.out.println("Please enter second operand");
     int operand2= Integer.parseInt(sc.nextLine());
     return operand2;   
   }
   public String getOperand() {
     Scanner sc = new Scanner(System.in); 
     System.out.println("Please choose one: PLUS MINUS MULTIPLY DIVIDE");
     String operand=sc.nextLine();
     return operand;
    }
}