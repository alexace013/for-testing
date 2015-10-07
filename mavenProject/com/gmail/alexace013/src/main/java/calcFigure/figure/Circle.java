package calcFigure.figure;

/**
 * Created by alexander on 07.10.15.
 */
public class Circle extends Box {

    public Circle() {
        super(0.0d);
    }

    public Circle(double diameter) {
        super(diameter);
    }

    @Override
    public double getVolume() {
        double radius = getHeight() / 2.0;  // should be just 2.0 instead of 2
        final double CONST_1 = 4.0 / 3.0;   // it should be only 4.0 and 3.0 ,
                                            // respectively, in place of 4 and 3
        double result = CONST_1 * Math.PI * (Math.pow(radius, 3));
        return result;
    }

    @Override
    public double getSquare() {
        double radius = getHeight() / 2;
        double square = Math.PI * Math.pow(radius, 2);
        return square;
    }

}
