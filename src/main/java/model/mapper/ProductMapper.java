package model.mapper;

import model.dto.ProductDto;
import model.entity.Product;

public interface ProductMapper {
    ProductDto productToProductDto(Product product);
}