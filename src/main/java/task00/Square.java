package task00;

public class Square implements Shape{
    private double side;

    public Square(double size) {
        this.side = size;
    }

    public double area() {
        return side * side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "size=" + side +
                '}';
    }
}
