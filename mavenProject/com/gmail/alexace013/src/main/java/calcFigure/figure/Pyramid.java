package calcFigure.figure;

/**
 * Created by alexander on 07.10.15.
 */
public class Pyramid extends Box {

    public Pyramid() {
        super(0.0d);
    }

    public Pyramid(double height, double square) {
        super(height);
        setSquare(square);
    }

    public void setSquare(double square) {
        setWidth(square);
    }

    @Override
    public double getSquare() {
        return getWidth();
    }

    @Override
    public double getVolume() {
        double result = (1.0 / 3.0) * getSquare() * getHeight();
        return result;
    }

}
