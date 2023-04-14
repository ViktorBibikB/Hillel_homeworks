package repo;

import exception.OrderDoesNotExistException;
import model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderInMemoryRepository implements OrderRepository {

    private final List<Order> orders = new ArrayList<>();


    @Override
    public Order getById(int id) throws OrderDoesNotExistException {
        return orders.stream()
                .filter(order -> order.getId() == id)
                .findFirst()
                .orElseThrow(() -> new OrderDoesNotExistException("Order with id " + id + " doesn't exist"));
    }

    @Override
    public List<Order> getAll() {
        return orders;
    }

    @Override
    public Order add(Order order) {
        orders.add(order);
        return order;
    }

}