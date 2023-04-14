package service;

import exception.OrderDoesNotExistException;
import model.Order;

import java.util.List;

public interface OrderService {

    Order getById(int id) throws OrderDoesNotExistException;
    List<Order> getAll();
    Order add(Order order);
}