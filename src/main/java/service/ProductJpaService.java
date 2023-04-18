package service;

import exceptions.ProductDoesNotExistException;
import model.dto.ProductDto;
import model.entity.Product;
import model.mapper.ProductMapper;
import repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductJpaService implements ProductService {

    private ProductMapper productMapper;
    private ProductRepository productRepository;


    @Override
    public ProductDto getById(Long id) throws ProductDoesNotExistException {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductDoesNotExistException("WRONG ID"));
        return productMapper.productToProductDto(product);
    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> all = new ArrayList<>();
        productRepository.findAll().forEach(all::add);
        return all.stream().map(productMapper::productToProductDto).collect(Collectors.toList());
    }

    private ProductDto productToProductDto(Product product) {
        return ProductDto.builder().id(product.getId())
                .name(product.getName())
                .cost(product.getCost())
                .orderId(product.getOrder().getId())
                .build();
    }

}