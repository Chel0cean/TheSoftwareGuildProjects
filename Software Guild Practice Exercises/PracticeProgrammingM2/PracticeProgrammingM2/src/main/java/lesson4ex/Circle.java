
package lesson4ex;
import java.lang.Math.*;

/**
 *
 * @author chelseamiller
 */
public class Circle extends shape{
    public String color = "red";
    public String name = "circle";
    private double radius;
    private double perimeter;
    private double area;
    
    public void Circle(double radius) {
        this.radius = radius;
    }
    
     public void setPerimeter() {
        this.perimeter = (2 * Math.PI *radius);
    }

    @Override
    double getPerimeter() {
        return perimeter;
    }

    
    protected void setArea() {
        this.area = Math.PI * (radius * radius);
    }
    @Override
    double getArea() {
        return area;
    }

    @Override
    void printInfo() {
        System.out.println("perimeter of the " + color +" " + name + " = " + perimeter + ", area of " + color +" "  + name + " = " + area);
    }
    
}
