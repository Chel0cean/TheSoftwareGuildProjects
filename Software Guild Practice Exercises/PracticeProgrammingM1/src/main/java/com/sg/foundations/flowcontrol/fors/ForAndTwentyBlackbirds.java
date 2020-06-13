
package com.sg.foundations.flowcontrol.fors;

/**
 *
 * @author chelseamiller
 */
public class ForAndTwentyBlackbirds {
     public static void main(String[] args) {
        int birdsInPie = 0;
        //I changed the i to <25 so that it will iterate 24x
        for (int i = 0; i < 25; i++) {
            System.out.println("Blackbird #" + i + " goes into the pie!");
            birdsInPie++;
        }
        //I changed the system printout to birdsinpie-1 so that this will run 24 not 25.
        System.out.println("There are " + (birdsInPie - 1) + " birds in there!");
        System.out.println("Quite the pie full!");
    }
}
