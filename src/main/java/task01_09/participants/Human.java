package task01_09.participants;

public class Human extends Participant{
    public Human(String name, double jumpHeight, double runLength) {
        super(name, jumpHeight, runLength);
    }

    @Override
    public void run() {
        System.out.println("Human " + getName() + "ran" + getRunLength());
    }

    @Override
    public void jump() {
        System.out.println("Human " + getName() + "jamp" + getJumpHeight());
    }
}
