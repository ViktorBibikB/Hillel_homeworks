package repo;

import model.Product;

import java.util.List;

public interface ProductDao {

    void remove(Product product);

    Product add(Product product);

    Product getById(int id);

    List<Product> getAll();
}