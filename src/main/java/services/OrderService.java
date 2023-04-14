package services;

import model.Order;
import model.Product;
import repo.OrderRepo;
import repo.OrderRepoInMemory;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private OrderRepo orderRepo = new OrderRepoInMemory();

    public OrderService() {
        Order or = new Order(1, new Product("ANOTHER HARDCODE", 78.5, 25),
                new Product("HARDCODE PRODUCT", 87.6, 13));
        orderRepo.addOrder(or);
        setCost(or);
    }

    public void addOrder(Order order) {
        order.setId(orderRepo.getOrders().size() + 1);
        setCost(order);
        orderRepo.addOrder(order);
    }

    public Order getOrderById(int id) {
        return orderRepo.getOrders().get(id);
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orderRepo.getOrders().values());
    }

    public void setCost(Order order) {
        double cost = 0;
        for (Product pr : order.getProductList()) {
            cost += pr.getCost();
        }
        order.setCost(cost);
    }
}
