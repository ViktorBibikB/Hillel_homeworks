package service;

import exceptions.OrderDoesNotExistException;
import model.dto.OrderDto;
import model.dto.ProductDto;
import model.entity.Order;
import model.entity.Product;
import model.mapper.OrderMapper;
import repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderJpaService implements OrderService {
    private OrderMapper orderMapper;

    private OrderRepository orderRepository;

    @Override
    public void add(OrderDto orderDto) {
        Order order = orderMapper.orderDtoToOrder(orderDto);
        double cost = 0;
        for (Product p : order.getProducts()) {
            p.setOrder(order);
            cost += p.getCost();
        }
        order.setCost(cost);
        order.setDate(LocalDateTime.now());
        orderRepository.save(order);
    }

    @Override
    public OrderDto getById(Long id) throws OrderDoesNotExistException {
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderDoesNotExistException("WRONG ID"));
        return orderMapper.orderToOrderDto(order);
    }

    @Override
    public List<OrderDto> getAll() {
        List<Order> all = new ArrayList<>();
        orderRepository.findAll().forEach(all::add);
        return all.stream().map(orderMapper::orderToOrderDto).collect(Collectors.toList());
    }

    @Override
    public void remove(OrderDto orderDto) {
        orderRepository.delete(orderMapper.orderDtoToOrder(orderDto));
    }

}