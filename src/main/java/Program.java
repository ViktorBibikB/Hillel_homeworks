import petrolStation.PetrolStation;
import petrolStation.RefuelFlow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Program {
    public static void main(String[] args) {
        PetrolStation petrolStation = new PetrolStation(50.0);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new RefuelFlow(1.0, petrolStation));
        executor.execute(new RefuelFlow(2.0, petrolStation));
        executor.execute(new RefuelFlow(3.0, petrolStation));
        executor.execute(new RefuelFlow(4.0, petrolStation));
        executor.execute(new RefuelFlow(5.0, petrolStation));

        executor.shutdown();
    }
}
