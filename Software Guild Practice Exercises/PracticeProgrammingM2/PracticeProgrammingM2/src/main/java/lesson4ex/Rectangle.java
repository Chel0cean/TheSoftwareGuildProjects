package lesson4ex;

/**
 *
 * @author chelseamiller
 */
public class Rectangle extends shape {

    public double length;
    public double width;
    public double perimeter;
    public double area;
    public String name = "rectangle";
    public String color = "pink";

    public void Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public void setPerimeter() {
        this.perimeter = (2 * length) + (2 * width);
    }

    @Override
    double getPerimeter() {
        return perimeter;
    }

    public void setArea() {
        this.area = width * length;

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
