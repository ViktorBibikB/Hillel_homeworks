package task01_09.participants;

public class Cat extends Participant{
    public Cat(String name, double jumpHeight, double runLength) {
        super(name, jumpHeight, runLength);
    }

    @Override
    public void run() {
        System.out.println("Cat " + getName() + "ran" + getRunLength());
    }

    @Override
    public void jump() {
        System.out.println("Cat " + getName() + "jamp" + getJumpHeight());
    }
}
