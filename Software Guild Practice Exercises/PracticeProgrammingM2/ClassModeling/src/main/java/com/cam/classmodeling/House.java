
package com.cam.classmodeling;

/**
 *
 * @author chelseamiller
 */
public class House {
    private double coordinateLat, coordinateLon;
       public int squareFootage;
       
       public HouseGPS() {
           
       } 
     /*
       for gps house
       Coordinates
    # of sq footage 
    
       
       for 3-d design
       #of bedrooms
       Sq feet
       # of bathrooms
       Color of exterior 
    address
       */ 
    public void setCoordinates(double coordinateLat, double coordinateLon) {
        this.coordinateLat = coordinateLat;
        this.coordinateLon = coordinateLon;
     } 
    public double getCoordinates() {
        return new House(coordinateLat, coordinateLon);
       
      
     } 
    
   public static void main(String[] args){
       
}
       
       
       
     public HouseGPS() {} 
         
     
     public HouseDesign() {}
         
     }
         

