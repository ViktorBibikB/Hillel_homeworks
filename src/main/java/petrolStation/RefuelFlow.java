package petrolStation;

public class RefuelFlow implements Runnable{
    private final double order;
    private final PetrolStation petrolStation;

    public RefuelFlow(double order, PetrolStation petrolStation) {
        this.order = order;
        this.petrolStation = petrolStation;
    }

    @Override
    public void run() {
        petrolStation.doRefuel(order);
    }
}
