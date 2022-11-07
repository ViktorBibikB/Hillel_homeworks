package task01_09.participants;

public abstract class Participant {
    private String name;
    private double jumpHeight;
    private double runLength;

    public Participant(String name, double jumpHeight, double runLength) {
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.runLength = runLength;
    }

    public abstract void run();
    public abstract void jump();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(double jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    public double getRunLength() {
        return runLength;
    }

    public void setRunLength(double runLength) {
        this.runLength = runLength;
    }
}
