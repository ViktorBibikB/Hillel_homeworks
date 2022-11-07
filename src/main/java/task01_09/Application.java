package task01_09;

import task01_09.obstacles.Obstacle;
import task01_09.obstacles.RunningTrack;
import task01_09.obstacles.Wall;
import task01_09.participants.Cat;
import task01_09.participants.Human;
import task01_09.participants.Participant;
import task01_09.participants.Robot;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Participant> participants = new ArrayList<>();
        participants.add(new Human("Rick", 1.01, 98.2));
        participants.add(new Human("Morty", 0.81, 115.3));
        participants.add(new Cat("Sqwash", 1.32, 158.2));
        participants.add(new Robot("Bender", 0.57, 1098.2));

        List<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(new RunningTrack("RunningTrack01", 58.7));
        obstacles.add(new Wall("Wall01", 0.87));
        obstacles.add(new RunningTrack("RunningTrack02", 98.7));
        obstacles.add(new Wall("Wall02", 0.87));
        obstacles.add(new RunningTrack("RunningTrack03", 125.4));

        passObstacle(participants, obstacles);
    }

    private static void passObstacle(List<Participant> participants, List<Obstacle> obstacles) {
        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.overcome(participant)) {
                    System.out.println("Participant " + participant.getName() + " didn't passed the obstacle " +
                            obstacle.getObstacleName() + " on the distance " + obstacle.getObstacleGeometry());
                    break;
                }
                else System.out.println("Participant " + participant.getName() + " passed the obstacle " +
                        obstacle.getObstacleName() + " on the distance " + obstacle.getObstacleGeometry());
            }
        }
    }
}
