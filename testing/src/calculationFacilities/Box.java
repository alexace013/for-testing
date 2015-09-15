package calculationFacilities;

/**
 * Created by alexander on 14.09.15.
 */
public class Box {

    private double height; // высота
    private double width; // ширина
    private double depth; // глубина

    public Box() {
        height = 0.0d;
        width = 0.0d;
        depth = 0.0d;
    }

    public  Box(int i) {}

    public Box(double height, double width, double depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void  setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getDepth() {
        return depth;
    }

    public double getVolume() {  // volume - объем
        double volume = getHeight() * getWidth() * getDepth();
        return volume;
    }



}
