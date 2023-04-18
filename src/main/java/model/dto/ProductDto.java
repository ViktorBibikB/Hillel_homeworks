package model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.entity.Order;
import model.entity.Product;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private double cost;
    private Long orderId;
    private Product product;

    public Product builder(){
        return new Product();
    }

    public Product id(Long id){
        product.setId(id);
        return product;
    }

    public Product name(String name){
        product.setName(name);
        return product;
    }

    public Product cost(double cost){
        product.setCost(cost);
        return product;
    }

    public Product orderId(Long orderId){
        product.setOrder(orderId);
        return product;
    }

}