package coffee.order;

import exeption.ErrorNameCustomer;
import exeption.ErrorOrdersList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class CoffeeOrderBoard {
    private static final Logger LOGGER = LogManager.getLogger(CoffeeOrderBoard.class);
    private int idOrder = 0;
    private List<Order> ordersList = new LinkedList<>();


    public void add(String nameCustomer, String... orders) {
        LOGGER.info("Add is working");
        try {
            if (nameCustomer == null || nameCustomer.equals("")) throw new ErrorNameCustomer("Customer name error");
            if (orders.length == 0) throw new ErrorOrdersList("list of orders cannot be empty");

            idOrder++;
            Order orderPerson = new Order(idOrder, nameCustomer, orders);
            ordersList.add(orderPerson);
            LOGGER.info("Create order: {} {}", orderPerson, Arrays.toString(orders));

        } catch (ErrorNameCustomer | ErrorOrdersList e) {
            LOGGER.error("Exception: {} {}", e.getMessage(), nameCustomer);
        }
    }

    public Order deliver() {
        LOGGER.info("Deliver is working");
        if (!ordersList.isEmpty()) {
            Order firstOrder = ordersList.get(0);
            LOGGER.info("Deliver order {}", firstOrder);
            ordersList.remove(0);
            return firstOrder;
        } else {
            LOGGER.info("Order list is empty");
        }
        return null;
    }

    public Order deliver(int idOrder) {
        LOGGER.info("Order is working");

        if (!ordersList.isEmpty()) {
            Order order;
            for (int i = 0; i < ordersList.size(); i++) {
                if (ordersList.get(i).getIdOrder() == idOrder) {
                    order = ordersList.get(i);
                    LOGGER.info("Deliver order {}", order);
                    ordersList.remove(i);
                    return order;
                }
            }
            LOGGER.info("there is no order for the specified id");
        } else {
            LOGGER.info("order list is empty");
        }
        return null;
    }


    public void draw() {
        LOGGER.info("Draw is working");

        System.out.println("====================");
        System.out.println("Num | Name ");
        for (Order order : ordersList) {
            System.out.println(order);
        }
    }
}
