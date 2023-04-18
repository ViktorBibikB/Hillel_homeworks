package service;

import model.Order;

import java.util.List;

public interface OrderService {

    Order add(Order order);

    Order getById(int id);

    List<Order> getAll();
}