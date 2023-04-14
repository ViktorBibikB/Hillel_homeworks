package repo;

import model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProductInMemoryRepository implements ProductRepository {

    private List<Product> productList;

    @Override
    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public Product getById(int id) {
        return productList.stream()
                .filter(product -> product.getId() == id)
                .findFirst().orElseThrow(()-> new RuntimeException("WRONG ID"));
    }
}