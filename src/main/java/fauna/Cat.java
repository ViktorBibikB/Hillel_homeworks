package fauna;

public class Cat extends Animal {
    private static int instanceCount;

    public Cat(String name) {
        super(name);
        instanceCount++;
    }

    public void run(double distance) throws IllegalArgumentException {
        if (distance < 0)
            throw new IllegalArgumentException("Cats run distance value can't be less then 0");
        if (distance > 200.0) {
            System.out.println("Cats max run distance is 200.");
        } else System.out.println("Cat ran distance - " + distance);
    }

    public void swim(double distance) throws IllegalArgumentException {
        if (distance >= 0.0 || distance < 0.0)
            System.out.println("Cats can't swim any distance.");
    }

    public static int getInstanceCount() {
        return instanceCount;
    }
}
