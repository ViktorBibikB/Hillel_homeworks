package fauna;

public class Cat extends Animal {
    private static int instanceCount;

    public Cat(String name) {
        super(name);
        instanceCount++;
    }

    public void run(double distance) {
        if (distance > 200.0) {
            throw new IllegalArgumentException();
        }
        System.out.println("Cat ran distance - " + distance);
    }

    public void swim(double distance) {
        if (distance >= 0.0 || distance < 0.0)
            System.out.println("Cats can't swim any distance.");
        System.out.println("Cat swam distance - " + distance);
    }

    public static int getInstanceCount() {
        return instanceCount;
    }
}
