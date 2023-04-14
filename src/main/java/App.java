import model.Product;
import service.Cart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("demo.repo", "demo.service");
        Scanner sc = new Scanner(System.in);

        Cart cartInMemory = context.getBean(Cart.class);
        Cart cart = context.getBean(Cart.class);


        boolean isExit = false;
        try {
            while (!isExit) {
                System.out.println("""
                        PLEASE CHOICE OPERATION
                        1 - ADD
                        2 - REMOVE
                        3 - EXIT
                        """);
                int input = sc.nextInt();
                switch (input) {
                    case 1 -> {
                        System.out.println("ENTER PRODUCT ID");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("ENTER PRODUCT NAME");
                        String name = sc.nextLine();
                        System.out.println("ENTER PRODUCT PRICE");
                        double price = sc.nextDouble();
                        sc.nextLine();
                        cartInMemory.add(new Product(id, name, price));
                        System.out.println("SUCCESSFULLY");
                    }
                    case 2 -> {
                        System.out.println("ENTER PRODUCT ID");
                        int id = sc.nextInt();
                        sc.nextLine();
                        cartInMemory.remove(id);
                        System.out.println("SUCCESSFULLY");
                    }
                    case 3 -> {
                        System.out.println("BYE");
                        isExit = true;
                    }
                    default -> System.out.println("TRY AGAIN");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("PLEASE ENTER THE NUMBER");
        } finally {
            sc.close();
        }
        System.out.println(cartInMemory);
        System.out.println(cart);
    }
}
