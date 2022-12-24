package petrolStation;

public class PetrolStation implements GasStation{
    private volatile Double amount;

    public PetrolStation(double amount) {
        this.amount = amount;
    }

    @Override
    public void doRefuel(double order) {
        System.out.println("amount = " + amount + ", order = " + order);

        if (amount - order < 0) {
            System.out.println("Order is too big");
            return;
        }

        decreaseAmount(order);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("amount = " + amount + ", you have got " + order);
    }

    private synchronized void decreaseAmount(double order) {
        amount -= order;
    }
}
