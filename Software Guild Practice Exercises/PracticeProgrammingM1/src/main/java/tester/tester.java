/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

/**
 *this was a test to understand something in the arrays (10) reading. 
 * @author chelseamiller
 */
public class tester {
    public static void main(String[] args){
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9 ,10};

    for (int i = 0; i < numbers.length - 2; i += 3) {
        System.out.println("Pair: (" + numbers[i] + ", " + numbers[i + 1] + ")");
    }
    }
    
}
