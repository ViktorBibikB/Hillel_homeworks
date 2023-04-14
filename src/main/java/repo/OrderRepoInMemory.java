package repo;

import model.Order;

import java.util.HashMap;

public class OrderRepoInMemory implements OrderRepo {
    private static HashMap<Integer, Order> orders = new HashMap<>();

    public HashMap<Integer, Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.put(order.getId(), order);
    }
}
