package service;

import exceptions.ProductDoesNotExistException;
import model.dto.ProductDto;
import model.entity.Product;

import java.util.List;

public interface ProductService {

    ProductDto getById(Long id) throws ProductDoesNotExistException;

    List<ProductDto> getAll();

}