package model.mapper;

import model.dto.OrderDto;
import model.dto.ProductDto;
import model.entity.Order;
import model.entity.Product;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class OrderMapperImpl implements OrderMapper {
    @Override
    public Order orderDtoToOrder(OrderDto orderDto) {
        if (orderDto == null) {
            return null;
        }

        Order order = new Order();
        List<Product> products = new LinkedList<>();
        for (ProductDto productDto : orderDto.getProducts()) {
            Product product = Product.builder()
                    .name(productDto.getName())
                    .cost(productDto.getCost())
                    .order(order)
                    .build();
            products.add(product);
        }
        order.setId(orderDto.getId());
        order.setCost(orderDto.getCost());
        order.setProducts(products);
        return order;
    }

    @Override
    public OrderDto orderToOrderDto(Order order) {
        if (order == null) {
            return null;
        }
        OrderDto orderDto = new OrderDto();
        List<ProductDto> products = new LinkedList<>();
        for (Product product : order.getProducts()) {
            ProductDto productDto = ProductDto.builder().id(product.getId())
                    .name(product.getName())
                    .cost(product.getCost())
                    .orderId(order.getId())
                    .build();
            products.add(productDto);
        }
        orderDto.setId(order.getId());
        orderDto.setCost(order.getCost());
        orderDto.setDate(order.getDate());
        orderDto.setProducts(products);
        return orderDto;
    }
}