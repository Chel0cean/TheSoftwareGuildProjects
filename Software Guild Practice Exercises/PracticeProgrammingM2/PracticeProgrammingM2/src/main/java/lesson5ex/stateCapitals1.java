package lesson5ex;

import java.util.Map;
import java.util.HashMap;

import java.util.Set;

/**
 *
 * @author chelseamiller
 */
public class stateCapitals1 {

    public static void main(String[] args) {

        Map<String, String> myStateCapitals = new HashMap<>();
        
        
        myStateCapitals.put("Alabama", "Montgomery");
        myStateCapitals.put("Alaska", "Juneau");
        myStateCapitals.put("Arizona", "Phoenix");
        myStateCapitals.put("Arkansas", "Little Rock");
        myStateCapitals.put("California", "Sacramento");
        myStateCapitals.put("Colorado", "Denver");
        myStateCapitals.put("Connecticut", "Hartford");
        myStateCapitals.put("Delaware", "Dover");
        myStateCapitals.put("Florida", "Tallahassee");
        myStateCapitals.put("Georgia", "Atlanta");
        myStateCapitals.put("Hawaii", "Honolulu");
        myStateCapitals.put("Idaho", "Boise");
        myStateCapitals.put("Illinois", "Springfield");
        myStateCapitals.put("Indiana", "Indianapolis");
        myStateCapitals.put("Iowa", "Des Moines");
        myStateCapitals.put("Kansas", "Topeka");
        myStateCapitals.put("Kentucky", "Frankfort");
        myStateCapitals.put("Louisiana", "Baton Rouge");
        myStateCapitals.put("Maine", "Augusta");
        myStateCapitals.put("Maryland", "Annapolis");
        myStateCapitals.put("Massachusetts", "Boston");
        myStateCapitals.put("Michigan", "Lansing");
        myStateCapitals.put("Minnesota", "Saint Paul");
        myStateCapitals.put("Mississippi", "Jackson");
        myStateCapitals.put("Missouri", "Jefferson City");
        myStateCapitals.put("Montana", "Helena");
        myStateCapitals.put("Nebraska", "Lincoln");
        myStateCapitals.put("Nevada", "Carson City");
        myStateCapitals.put("New Hampshire", "Concord");
        myStateCapitals.put("New Jersey", "Trenton");
        myStateCapitals.put("New Mexico", "Santa Fe");
        myStateCapitals.put("New York", "Albany");
        myStateCapitals.put("North Carolina", "Raleigh");
        myStateCapitals.put("North Dakota", "Bismarck");
        myStateCapitals.put("Ohio", "Columbus");
        myStateCapitals.put("Oklahoma", "Oklahoma City");
        myStateCapitals.put("Oregon", "Salem");
        myStateCapitals.put("Pennsylvania", "Harrisburg");
        myStateCapitals.put("Rhode Island", "Providence");
        myStateCapitals.put("South Carolina", "Columbia");
        myStateCapitals.put("South Dakota", "Pierre");
        myStateCapitals.put("Tennessee", "Nashville");
        myStateCapitals.put("Texas", "Austin");
        myStateCapitals.put("Utah", "Salt Lake City");
        myStateCapitals.put("Vermont", "Montpelier");
        myStateCapitals.put("Virginia", "Richmond");
        myStateCapitals.put("Washington", "Olympia");
        myStateCapitals.put("West Virginia", "Charleston");
        myStateCapitals.put("Wisconsin", "Madison");
        myStateCapitals.put("Wyoming", "Cheyenne");
        
        
        Set<String> keys = myStateCapitals.keySet();
        
        System.out.println("States:");
        System.out.println("=======");
        for (String k : keys) {
            System.out.println(k);
        }
        
        
        System.out.println("");
        System.out.println("");
        System.out.println("Capitals");
        System.out.println("=======");
        for (String k : keys) {
            System.out.println(myStateCapitals.get(k));
        }
        
        
        System.out.println("");
        System.out.println("");
        System.out.println("State/Capital Pairs");
        System.out.println("=======");
        for (String k : keys) {
            System.out.println("The capital of " + k
                    + " is " + myStateCapitals.get(k));
        }
    }
}
