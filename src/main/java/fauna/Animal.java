package fauna;

public abstract class Animal {

    protected String name;
    private double distance;
    private static int instanceCount;

    public Animal(String name) {
        this.name = name;
        instanceCount++;
    }

    public abstract void run(double distance);
    public abstract void swim(double distance);

    public static int getInstanceCount() {
        return instanceCount;
    }
}
