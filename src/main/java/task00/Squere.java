package task00;

public class Squere implements Shape{
    private double size;

    public Squere(double size) {
        this.size = size;
    }

    public double area() {
        return size * size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Squere{" +
                "size=" + size +
                '}';
    }
}
