package coffee.order;

public class Program {
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add(new Order("Antony"));
        coffeeOrderBoard.add(new Order("Den"));
        coffeeOrderBoard.add(new Order("Max"));
        coffeeOrderBoard.add(new Order("Sergey"));


        coffeeOrderBoard.draw();
        System.out.println("----------------");

        coffeeOrderBoard.deliver(2);
        coffeeOrderBoard.draw();
        System.out.println("----------------");

        coffeeOrderBoard.deliver();
        coffeeOrderBoard.draw();

//        CoffeeOrderBoard coffeeOrderBoard1 = new CoffeeOrderBoard();
//        coffeeOrderBoard1.add(new Order("Viktor_1"));
//        coffeeOrderBoard1.add(new Order("Den_1"));
//        coffeeOrderBoard1.add(new Order("Max_1"));
//        coffeeOrderBoard1.add(new Order("Sergey_1"));
//
//        coffeeOrderBoard1.printQueue();
    }
}
