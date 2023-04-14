package repo;

import model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getProductList();

    Product getById(int id);
}
