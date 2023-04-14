import coffee.order.CoffeeOrderBoard;
import coffee.order.Order;
import exeption.ErrorNameCustomer;

public class App {
    public static void main(String[] args) throws ErrorNameCustomer {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();

        orderBoard.add("User_1", "Tea", "Cake", "Candy");
        orderBoard.add("User_2", "Tea", "Cake");
        orderBoard.add(null, "Apple juice");

        orderBoard.deliver();
        orderBoard.deliver(2);
        orderBoard.deliver(5);
    }
}
