package task01_09.obstacles;

import task01_09.participants.Participant;

public class Wall extends Obstacle{
    public Wall(String name, double length) {
        super(name, length);
    }

    @Override
    public boolean overcome(Participant participant) {
        return participant.getJumpHeight() >= getObstacleGeometry();
    }
}
