
package com.sg.foundations.basics.arrays;

/**
 *
 * @author chelseamiller
 */
public class FruitSalad {
    public static void main(String[] args) {
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",  "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};

        String[] fruitSalad = new String[12];
        int nextIndex = 0;
        int orangeCount = 0;
        int appleCount = 0;
        int berryCount = 0;
        int totalFruit = 0;

        for(int i=0; i< fruit.length; i++) {
            if(fruit[i].contains("berry") && fruitSalad.length <13){
          berryCount++;
          fruitSalad[nextIndex] = fruit[i];
          System.out.println(fruitSalad[nextIndex]);
          ++nextIndex;
         }
        }
        for(int i=0; i< fruit.length; i++) {
            if(fruit[i].contains("Orange") && orangeCount <2 && fruitSalad.length <13){
              ++orangeCount;
             fruitSalad[nextIndex] = fruit[i];
             System.out.println(fruitSalad[nextIndex]);
             ++nextIndex;    
         } 
        }
        for(int i=0; i< fruit.length; i++) {
          if(fruit[i].contains("Apple") && appleCount <3 && fruitSalad.length <13){
              ++appleCount;
             fruitSalad[nextIndex] = fruit[i];
             System.out.println(fruitSalad[nextIndex]);
             ++nextIndex;    
         } 
        }
        for(int i=0; i< fruit.length; i++) {
          if(!(fruit[i].contains("Tomato")) &&!(fruit[i].contains("Apple")) && !(fruit[i].contains("Orange")) && !(fruit[i].contains("berry")) && fruitSalad.length <13){
             fruitSalad[nextIndex] = fruit[i];
             System.out.println(fruitSalad[nextIndex]);
             ++nextIndex;
             if(nextIndex == 12){
                 break;
             }
          }
        
        }
        System.out.println("Total # of berries: "+berryCount);
        System.out.println("Total # of apples: "+appleCount);
        System.out.println("Total # of oranges: "+orangeCount);
        System.out.println("Total # of fruit: "+fruitSalad.length);
        
    }
}
