package model.mapper;

import model.dto.OrderDto;
import model.entity.Order;

public interface OrderMapper {

    Order orderDtoToOrder(OrderDto orderDto);
    OrderDto orderToOrderDto(Order order);

}