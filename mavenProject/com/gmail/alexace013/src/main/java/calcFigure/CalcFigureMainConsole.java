package calcFigure;

import calcFigure.figure.Circle;
import calcFigure.figure.Cube;
import calcFigure.figure.Cylinder;

/**
 * Created by alexander on 07.10.15.
 */
public class CalcFigureMainConsole {

    public static void main(String[] args) {

        Circle circle = new Circle(14);
        Cube cube = new Cube(25);
        Cylinder cylinder = new Cylinder(9, 4);

        System.out.println("circle volume: " + circle.getVolume());
        System.out.println("cube volume: " + cube.getVolume());
        System.out.println("cylinder volume: " + cylinder.getVolume());

    }

}
