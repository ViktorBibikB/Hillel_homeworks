package fauna;

public class Dog extends Animal {
    private static int instanceCount;

    public Dog(String name) {
        super(name);
        instanceCount++;
    }

    public void run(double distance) throws IllegalArgumentException {
        if (distance < 0)
            throw new IllegalArgumentException("Dogs run distance value can't be less then 0");
        if (distance > 500.0)
            System.out.println("Dogs max run distance is 500.");
        else System.out.println("Dog ran distance - " + distance);
    }

    public void swim(double distance) throws IllegalArgumentException {
        if (distance < 0)
            throw new IllegalArgumentException("Dogs swim distance value can't be less then 0");
        if (distance > 10.0)
            System.out.println("Dogs swim to 10 meters." + distance);
        else System.out.println("Dog swam distance - " + distance);
    }

    public static int getInstanceCount() {
        return instanceCount;
    }
}
