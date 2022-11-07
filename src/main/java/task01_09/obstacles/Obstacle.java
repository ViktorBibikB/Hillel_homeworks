package task01_09.obstacles;

import task01_09.participants.Participant;

public abstract class Obstacle {
    private String obstacleName;
    private double obstacleGeometry;

    public Obstacle(String obstacleName, double obstacleGeometry) {
        this.obstacleName = obstacleName;
        this.obstacleGeometry = obstacleGeometry;
    }

    public abstract boolean overcome(Participant participant);

    public String getObstacleName() {
        return obstacleName;
    }

    public void setObstacleName(String obstacleName) {
        this.obstacleName = obstacleName;
    }

    public double getObstacleGeometry() {
        return obstacleGeometry;
    }

    public void setObstacleGeometry(double obstacleLength) {
        this.obstacleGeometry = obstacleGeometry;
    }
}
