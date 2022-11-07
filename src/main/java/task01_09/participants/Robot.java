package task01_09.participants;

public class Robot extends Participant{
    public Robot(String name, double jumpHeight, double runLength) {
        super(name, jumpHeight, runLength);
    }

    @Override
    public void run() {
        System.out.println("Robot " + getName() + "ran" + getRunLength());
    }

    @Override
    public void jump() {
        System.out.println("Robot " + getName() + "jamp" + getJumpHeight());
    }
}
