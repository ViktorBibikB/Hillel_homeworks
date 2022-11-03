package fauna;

public class Dog extends Animal{
    private static int instanceCount;

    public Dog(String name) {
        super(name);
        instanceCount++;
    }

    public void run(double distance) {
        if(distance > 500.0)
            throw new IllegalArgumentException();
        System.out.println("Dog ran distance - " + distance);
    }

    public void swim(double distance) {
        if (distance > 10.0) {
            System.out.println("Dogs swim to 10 meters." + distance);
            throw new IllegalArgumentException();
        }
        System.out.println("Dog swam distance - " + distance);
    }

    public static int getInstanceCount() {
        return instanceCount;
    }
}
