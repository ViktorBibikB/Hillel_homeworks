package service;

import exceptions.OrderDoesNotExistException;
import model.dto.OrderDto;

import java.util.List;

public interface OrderService {

    void add(OrderDto orderDto);

    OrderDto getById(Long id) throws OrderDoesNotExistException;

    List<OrderDto> getAll();

    void remove(OrderDto orderDto);
}