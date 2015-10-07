package calcFigure.figure;

/**
 * Created by alexander on 07.10.15.
 */
public class Cylinder extends Box {

    public Cylinder() {
        super(0.0d);
    }

    public Cylinder(double height, double width) {
        super(height, width);
    }

    public double getVolume() {
        double radius = getWidth() / 2.0;   // should be just 2.0 instead of 2
        double result = Math.PI * Math.pow(radius, 2.0) * getHeight();
        return result;
    }

}
