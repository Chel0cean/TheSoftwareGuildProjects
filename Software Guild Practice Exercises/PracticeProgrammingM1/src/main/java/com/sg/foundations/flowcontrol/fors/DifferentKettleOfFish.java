
package com.sg.foundations.flowcontrol.fors;

/**
 *
 * @author chelseamiller
 */
public class DifferentKettleOfFish {
    public static void main(String[] args) {

        int fish = 1;
        /*by using a for loop instead of a while loop i put the fish increment in the 
        condition instead of in the function. Aside from that not much else changed.
        */
        for(fish=1; fish <=10; fish++){
        if(fish == 3){
                System.out.println("RED fish!");
            }else if(fish == 4){
                System.out.println("BLUE fish!");
            } else{
                System.out.println(fish + " fish!");
            }    
        }
        
        
        /*while(fish < 10){
            if(fish == 3){
                System.out.println("RED fish!");
            }else if(fish == 4){
                System.out.println("BLUE fish!");
            } else{
                System.out.println(fish + " fish!");
            }

            fish++;
        }*/

    }
    
}
