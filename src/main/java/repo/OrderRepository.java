package repo;

import model.Order;

import java.util.List;

public interface OrderRepository {

    Order getById(int id);
    List<Order> getAll();
    Order add(Order order);
}