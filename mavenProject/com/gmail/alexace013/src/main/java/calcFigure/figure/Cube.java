package calcFigure.figure;

/**
 * Created by alexander on 07.10.15.
 */
public class Cube extends Box {

    public Cube() {
        super(0.0d);
    }

    public Cube(double side) {
        super(side);
    }

    @Override
    public double getVolume() {
        double result = Math.pow(getHeight(), 3);
        return result;
    }

    @Override
    public double getSquare() {
        double square = Math.pow(getHeight(), 2);
        return square;
    }

}
