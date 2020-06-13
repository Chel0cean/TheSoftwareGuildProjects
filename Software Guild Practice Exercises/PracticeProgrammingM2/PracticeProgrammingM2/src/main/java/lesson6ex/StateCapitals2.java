
package lesson6ex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author chelseamiller
 */
public class StateCapitals2 {

    public static void main(String[] args) throws Exception {
        int count = 0;
        int iterate;

        Map<String, String> myStateCapitals = new HashMap<>();
        Scanner sc = new Scanner(new BufferedReader(new FileReader("StateCapitals.txt")));
        Scanner inputReader = new Scanner(System.in);
        Random rand = new Random();

        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine(); //one entire line at a time
            String[] pairs = currentLine.split("::"); //split along the delimiter
            myStateCapitals.put(pairs[0], pairs[1]); //enter into map
        }
        Set<String> keys = myStateCapitals.keySet();

        for (String x : keys) {
            count++;

            //System.out.println(x);
        }
        System.out.println("There are " + count + " state/capital pairs inside of this map.");

        for (String x : keys) {
            System.out.println(x);

        }

        Object[] arr = keys.toArray();
        int index = rand.nextInt((49 - 0) + 1) + 0;
        String state = arr[index].toString();

        System.out.println("Can you guess the capital of " + state + "?");
        String capitalGuess = inputReader.nextLine();
        String capital = myStateCapitals.get(state);
        if (!capitalGuess.equalsIgnoreCase(capital)) {
            System.out.println("Incorrect! " + capital + " is the capital of " + state);
        } else {
            System.out.println("Correct! " + capital + " is the capital of " + state);
        }

    }
}
