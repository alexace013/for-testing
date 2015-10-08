package calcFigure.figure;

import calcFigure.figureImpl.FigureParam;

/**
 * Created by alexander on 07.10.15.
 */
public class Box implements FigureParam {

    private double height;
    private double width;
    private double depth;

    public Box() {
        height = 0.0d;
        width = 0.0d;
        depth = 0.0d;
    }

    public Box(double value) {
        this.height = this.width = this.depth = value;
    }

    public Box(double height, double width) {
        this.height = height;
        this.width = width;
        depth = 0.0d;
    }

    public Box(double height, double width, double depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getVolume() {
        double result = getHeight() + getWidth() + getDepth();
        return result;
    }

    public double getSquare() {
        double square = getHeight() * getWidth();
        return square;
    }

}
