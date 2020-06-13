
package ui;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author chelseamiller
 */
public class UserIOConsoleImpl implements UserIO {

    Scanner inputReader = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String input = inputReader.nextLine();
        return input;
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        int input = Integer.parseInt(inputReader.nextLine());
        return input;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        System.out.println(prompt);
        int input = Integer.parseInt(inputReader.nextLine());
        while (!(input >= min && input <= max)) {
            System.out.println(input + " isn't between " + min + " and " + max + " please try again:");
            input = Integer.parseInt(inputReader.nextLine());
        }
        return input;
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        double input = Double.parseDouble(inputReader.nextLine());
        return input;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
         System.out.println(prompt);
        double input = Double.parseDouble(inputReader.nextLine());
        while (!(input >= min && input <= max)) {
            System.out.println(input + " isn't between " + min + " and " + max + " please try again:");
            input = Integer.parseInt(inputReader.nextLine());
        }
        return input;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        float input = Float.parseFloat(inputReader.nextLine());
        return input;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
         System.out.println(prompt);
        Float input = Float.parseFloat(inputReader.nextLine());
        while (!(input >= min && input <= max)) {
            System.out.println(input + " isn't between " + min + " and " + max + " please try again:");
            input = Float.parseFloat(inputReader.nextLine());
        }
        return input;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        long input = Long.parseLong(inputReader.nextLine());
        return input;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
         System.out.println(prompt);
        long input = Long.parseLong(inputReader.nextLine());
        while (!(input >= min && input <= max)) {
            System.out.println(input + " isn't between " + min + " and " + max + " please try again:");
            input = Long.parseLong(inputReader.nextLine());
        }
        return input;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) {
       System.out.println(prompt);
        BigDecimal input = new BigDecimal(inputReader.nextLine());
        return input;
    }

}
