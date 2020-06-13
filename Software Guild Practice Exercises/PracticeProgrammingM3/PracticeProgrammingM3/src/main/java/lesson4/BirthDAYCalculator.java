package lesson4;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import static java.util.Calendar.YEAR;
import java.util.Scanner;


/**
 *
 * @author chelseamiller Welcome to the Magical BirthDAY Calculator!
 *
 * What's your birthday? 01-01-2002 That's means you were born on a TUESDAY!
 * This year it falls on a MONDAY... And since today is 12-30-2018, there's only
 * 2 more days until the next one! Bet yer excited to be turning 17!
 */
public class BirthDAYCalculator {

    public static void main(String[] args) throws ParseException {
        //initialize scanner named sc
        Scanner sc = new Scanner(System.in);
        
        //initialize date variable named ld and set it to today's date using .now()
        LocalDate ld = LocalDate.now();
        
        //format date to mm/dd/yyyy and set it to a string called formattedld
        String formattedld = ld.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        
        //outprints to get birthday
        System.out.println("Welcome to the Magical BirthDAY Calculator!");
        System.out.println("What's your birthday? (yyyy-MM-dd)");
        
        //sets birthday to string called birthday
        String birthday = sc.nextLine();
        
        //turns birthday string into a localdate object called bd
        LocalDate bd = LocalDate.parse(birthday);

        //formats bd into mm/dd/yyyy and converts it to a string called formattedbd
        String formattedbd = bd.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        
        //need to gather weekday of birthdate
        System.out.println("That means that you were born on a "+bd.getDayOfWeek());
        
        //changes birthdate entry to have the same year as the current date
        LocalDate nextBDay = bd.withYear(ld.getYear());
        
        //changes the year in case the birthday has already passed.
         if (nextBDay.isBefore(ld) || nextBDay.isEqual(ld)) {
            nextBDay = nextBDay.plusYears(1);
        }
         
         System.out.println("This year your birthday falls on a "+ nextBDay.getDayOfWeek()+".");
         System.out.println("And since today is "+formattedld+",");
         
         Period p = Period.between(ld, nextBDay);
        long p2 = ChronoUnit.DAYS.between(ld, nextBDay);
        Period diff = bd.until(nextBDay);
        int years=diff.getYears();
        System.out.println("there are " + p.getMonths() + " months, and " +
                           p.getDays() + " days until your next birthday. (" +
                           p2 + " days until you turn "+years+".)");
        
        //test to see values of variables in console 
      //System.out.println(nextBDay); 

    }

}
