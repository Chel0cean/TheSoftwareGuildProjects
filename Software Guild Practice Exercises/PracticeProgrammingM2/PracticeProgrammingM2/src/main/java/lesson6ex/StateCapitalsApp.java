package lesson6ex;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author chelseamiller
 */
public class StateCapitalsApp {

    public static void main(String[] args) throws Exception {
        int count = 0;

        HashMap<String, StateCapitals3> myStateCapitals = new HashMap<>();
        Scanner msc = new Scanner(new BufferedReader(new FileReader("MoreStateCapitals.txt")));
        Scanner inputReader = new Scanner(System.in);

        while (msc.hasNextLine()) {
            String currentLine = msc.nextLine(); //one entire line at a time
            String[] pairs = currentLine.split("::"); //split along the delimiter
            myStateCapitals.put(pairs[0], new StateCapitals3(new String(pairs[1]), new String(pairs[2]), new String(pairs[3])));

        }

        Set<String> keys = myStateCapitals.keySet();

        for (String x : keys) {

            System.out.println(x + " - " + myStateCapitals.get(x).getName() + " - pop: " + myStateCapitals.get(x).getPopulation() + " - area: " + myStateCapitals.get(x).getSquareMileage() + " sq mi");

        }
        System.out.println("Please input a population limit and I will print all of the capitals with a greater population:");
        int popMin = Integer.parseInt(inputReader.nextLine());
        System.out.println("Capitals with a greater population than " + popMin + " are:");
        for (String x : keys) {
            int pop = Integer.parseInt(myStateCapitals.get(x).getPopulation());

            if (pop > popMin) {
                System.out.println(myStateCapitals.get(x).getName()+  ", " + x + " - pop: " + myStateCapitals.get(x).getPopulation());
            }

        }
        System.out.println("Please input an area limit and I will print all of the capitals with a smaller area:");
        double areaMax = Double.parseDouble(inputReader.nextLine());
        System.out.println("Capitals with less than " + areaMax + " square miles are:");
        for (String x : keys) {
            double area = Double.parseDouble(myStateCapitals.get(x).getSquareMileage());

            if (area < areaMax) {
                System.out.println(myStateCapitals.get(x).getName()+  ", " + x + " - area: " + myStateCapitals.get(x).getSquareMileage() + " sq mi");
            }

        }
    }
}
