package calcFigure.figure;

/**
 * Created by alexander on 07.10.15.
 */
public class Pyramid extends Box {

    public Pyramid() {
        super(0.0d);
    }

    public Pyramid(double height, double sideA, double sideB) {
        super(height);
        setWidth(sideA);
        setDepth(sideB);
    }

    @Override
    public double getSquare() {
        double result = getWidth() * getDepth();
        return result;
    }

    @Override
    public double getVolume() {
        double result = (1.0 / 3.0) * getSquare() * getHeight();
        return result;
    }

}
