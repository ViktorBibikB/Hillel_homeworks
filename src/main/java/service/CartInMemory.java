package service;

import model.Product;
import repo.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@AllArgsConstructor

public class CartInMemory implements Cart {

    private ProductRepository productRepository;


    @Override
    public void add(Product product) {
        productRepository.getProductList().add(product);
    }

    @Override
    public void remove(int id) {
        Product product = productRepository.getById(id);
        productRepository.getProductList().remove(product);

    }
}

