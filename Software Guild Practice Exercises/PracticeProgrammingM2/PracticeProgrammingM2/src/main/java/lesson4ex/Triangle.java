package lesson4ex;
import java.lang.Math.*;

/**
 *
 * @author chelseamiller
 */
public class Triangle extends shape {

    public double base;
    double side1;
    double side2;
    public double height;
    public double perimeter;
    public double area;
    public String name = "triangle";
    public String color = "green";
    
    public void Triangle(double base, double side1, double side2){
        this.base = base;
        this.side1 = side1;
        this.side2 = side2;
    }
    
    public void setPerimeter(){
        this.perimeter = base+side1+side2;
        
    }

    @Override
    double getPerimeter() {
        return perimeter;
    }
    
    public void setArea(){
        double heronsFormula = (base + side1 + side2) * (-base + side1 + side2) * (base - side1 + side2) * (base + side1 - side2);
        this.area = Math.sqrt(heronsFormula) * 0.25;
    }

    @Override
    double getArea() {
        return area;
    }

    @Override
    void printInfo() {
        System.out.println("perimeter of the " + color + " " + name + " = " + perimeter + ", area of " + color + " " + name + " = " + area);

    }

}
