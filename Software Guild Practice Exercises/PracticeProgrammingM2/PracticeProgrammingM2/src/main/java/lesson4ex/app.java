/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson4ex;

/**
 *
 * @author chelseamiller
 */
public class app {

    public static void main(String[] args) {
        Square mySquare = new Square();
        Circle myCircle = new Circle();
        Rectangle myRectangle = new Rectangle();
        Triangle myTriangle = new Triangle();

        mySquare.Square(5);
        mySquare.setPerimeter();
        mySquare.setArea();
        mySquare.printInfo();

        myCircle.Circle(5);
        myCircle.setPerimeter();
        myCircle.setArea();
        myCircle.printInfo();

        myRectangle.Rectangle(2, 4);
        myRectangle.setArea();
        myRectangle.setPerimeter();
        myRectangle.printInfo();

        myTriangle.Triangle(6, 4, 3);
        myTriangle.setArea();
        myTriangle.setPerimeter();
        myTriangle.printInfo();

        //System.out.println("perimeter of = "+ mySquare.getPerimeter() +", area of = "+ mySquare.getArea());
    }
}
