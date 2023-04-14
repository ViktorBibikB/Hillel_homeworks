package repo;

import model.Order;

import java.util.HashMap;

public interface OrderRepo {
    HashMap<Integer, Order> getOrders();

    void addOrder(Order order);
}
