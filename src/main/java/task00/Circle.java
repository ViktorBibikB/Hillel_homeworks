package task00;

public class Circle implements Shape{
    private final double PVALUE = 3.14;
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public double area() {
        return radius * PVALUE;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                ", radius=" + radius +
                '}';
    }
}
