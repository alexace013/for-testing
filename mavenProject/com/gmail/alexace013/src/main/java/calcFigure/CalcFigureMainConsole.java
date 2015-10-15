package calcFigure;

import calcFigure.figure.Circle;
import calcFigure.figure.Cube;
import calcFigure.figure.Cylinder;
import calcFigure.figure.Pyramid;

/**
 * Created by alexander on 07.10.15.
 */
public class CalcFigureMainConsole {

    public static void main(String[] args) {

        Circle circle = new Circle(14);
        Cube cube = new Cube(25);
        Cylinder cylinder = new Cylinder(9, 4);
        Pyramid pyramid = new Pyramid(14, 70);
        pyramid.getSquare();

        System.out.println("circle volume: " + circle.getVolume());
        System.out.println("cube volume: " + cube.getVolume());
        System.out.println("cylinder volume: " + cylinder.getVolume());
        System.out.println("pyramid volume: " + pyramid.getVolume());

        Circle circle1 = new Circle();
        Cube cube1 = new Cube();
        Cylinder cylinder1 = new Cylinder();
        Pyramid pyramid1 = new Pyramid();
        pyramid1.getSquare();

        System.out.println("circle1 volume: " + circle1.getVolume());
        System.out.println("cube1 volume: " + cube1.getVolume());
        System.out.println("cylinder1 volume: " + cylinder1.getVolume());
        System.out.println("pyramid1 volume: " + pyramid1.getVolume());

    }

}
