
package interestCalculator;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 *
 * @author chelseamiller
 */
public class interestCalculator {
    public void calculate(){
Scanner inputReader = new Scanner(System.in);
int years; 
double initial, interest, sum, total, starting, difference, earned, freq;
double annualGain= 0;
System.out.println("How much money would you like to invest? ");
initial = Double.parseDouble(inputReader.nextLine());
total = initial;

System.out.println("How many years are you investing?");
years = Integer.parseInt(inputReader.nextLine());

System.out.println("What is the annual interest rate % growth?");
interest = Double.parseDouble(inputReader.nextLine());

System.out.println("Would you like your interest compounded daily(365), monthly(12), or quarterly(4)?");
freq = Integer.parseInt(inputReader.nextLine());

System.out.println("Calculating...");
        for(int i=1; i<=years; i++){
            for(int j= 1; j<=freq; j++){
                starting = total;
               sum = total * (1 + ((interest/freq) / 100));
               difference = sum - total;
               total+= difference;
               annualGain = total - initial;
            }
            BigDecimal annualGainBD = new BigDecimal(annualGain);
            BigDecimal roundAnnualGain = annualGainBD.setScale(2, RoundingMode.HALF_UP);
            
            BigDecimal initialBD = new BigDecimal(initial);
            BigDecimal roundInitial = initialBD.setScale(2, RoundingMode.HALF_UP);
            
            BigDecimal totalBD = new BigDecimal(total);
            BigDecimal roundTotal = totalBD.setScale(2, RoundingMode.HALF_UP);
            
            
            System.out.println("Year " + i +":");
            System.out.println("Began with: $" + roundInitial);
            System.out.println("Earned: $" + roundAnnualGain);
            System.out.println("Ended with: $" + roundTotal);
            initial = total;
           
            
        }
        
        
    }
}
