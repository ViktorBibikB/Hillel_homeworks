package repo;

import model.Cart;
import model.Product;

public interface CartDao {

    void remove(Cart cart);

    Cart add(Cart cart);

    Cart getById(int id);

}
