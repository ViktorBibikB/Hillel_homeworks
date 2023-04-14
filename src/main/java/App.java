import coffee.order.CoffeeOrderBoard;
import exeption.ErrorCustomerName;

public class App {
    public static void main(String[] args) throws ErrorCustomerName {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();

        orderBoard.add("User_1", "Tea", "Cake", "Candy");
        orderBoard.add("User_2", "Tea", "Cake");
        orderBoard.add(null, "Juice");

        orderBoard.deliver();
        orderBoard.deliver(2);
        orderBoard.deliver(5);
    }
}
