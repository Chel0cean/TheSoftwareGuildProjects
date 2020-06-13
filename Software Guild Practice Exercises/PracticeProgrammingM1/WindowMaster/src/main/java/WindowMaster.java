
import java.util.Scanner;


/**
 *
 * @author chelseamiller
 */

public class WindowMaster {
    public static void main(String[] args) {
        float height;
        float width;
        String stringHeight;
        String stringWidth;
        float areaOfWindow;
        float costOfGlass;
        float costOfTrim;
        String stringGlass;
        String stringTrim;
        float numberOfWindows;
        String stringWindowCount;
        float cost;
        float perimeterOfWindow;
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("Please enter number of windows: ");
        stringWindowCount = myScanner.nextLine();
        numberOfWindows = Float.parseFloat(stringWindowCount);
        System.out.println("Please enter window height:");
        stringHeight = myScanner.nextLine();
        height = Float.parseFloat(stringHeight);
        System.out.println("Please enter window width:");
        stringWidth = myScanner.nextLine();
        width = Float.parseFloat(stringWidth);
        System.out.println("Please enter cost of glass: ");
        stringGlass = myScanner.nextLine();
        costOfGlass = Float.parseFloat(stringGlass);
        System.out.println("Please enter cost of trim: ");
        stringTrim = myScanner.nextLine();
        costOfTrim =  Float.parseFloat(stringTrim);
      
       
            
            
        
        
    
        areaOfWindow = height * width;
        perimeterOfWindow = 2 * (height + width);
        
        cost = (numberOfWindows * ((costOfGlass * areaOfWindow) + (costOfTrim * perimeterOfWindow)));
        System.out.println("Window Count= " + stringWindowCount);
        System.out.println("Window height= " + stringHeight);
        System.out.println("Window width= " + stringWidth);
        System.out.println("Window area= " + areaOfWindow);
        System.out.println("Window perimeter= " + perimeterOfWindow);
        System.out.println("Cost of glass= " + costOfGlass);
        System.out.println("Cost of trim= " +costOfTrim);
        System.out.println("Total Cost= " + cost);
    }
        
}
