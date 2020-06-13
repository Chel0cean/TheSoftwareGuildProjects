package lesson3;

import java.util.Scanner;

/**
 *
 * @author chelseamiller
 */

public class weekdays {
    public String getDay() {
     Scanner sc = new Scanner(System.in); 
     System.out.println("Which day of the week is it?");
     String weekday=sc.nextLine();
     return weekday;
    }

    public int calculateDays(weekdayEnum day) {
        switch (day) {
            case MONDAY:
                return 4;
            case TUESDAY:
                return 3;
            case WEDNESDAY:
                return 2;
            case THURSDAY:
                return 1;
            case FRIDAY:
                return 0;
            case SATURDAY:
                return 6;
            case SUNDAY:
                return 5;
            default:
                throw new UnsupportedOperationException();
        }
    
    }
  
}

