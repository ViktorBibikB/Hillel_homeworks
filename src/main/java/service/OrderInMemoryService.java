package service;

import exception.OrderDoesNotExistException;
import model.Order;
import model.Product;
import repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderInMemoryService implements OrderService {
    private OrderRepository orderRepository;

    @Override
    public Order getById(int id) throws OrderDoesNotExistException {
        return orderRepository.getById(id);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    @Override
    public Order add(Order order) {
        double cost = 0;
        for (Product p : order.getProducts()) {
            cost += p.getCost();
        }
        order.setCost(cost);
        orderRepository.add(order);
        order.setId(orderRepository.getAll().size());
        return order;
    }
}
