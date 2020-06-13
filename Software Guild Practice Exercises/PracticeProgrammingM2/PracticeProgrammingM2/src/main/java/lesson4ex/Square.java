package lesson4ex;

public class Square extends shape {

    private double side;
    private double perimeter;
    private double area;
    public String color = "blue";
    public String name = "square";

    public void Square(double side) {
        this.side = side;
    }

   
    public void setPerimeter() {
        this.perimeter = 4 * side;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }

    protected void setArea() {
        this.area = side * side;
    }

    @Override
    protected double getArea() {
        return area;
    }
    
    @Override
    public void printInfo() {
        System.out.println("perimeter of the " + color +" " + name + " = " + perimeter + ", area of " + color +" "  + name + " = " + area);
    }

}
