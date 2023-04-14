package config;

import model.Cart;
import model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartRowMapper implements RowMapper<Cart> {

    Cart cart = new Cart();
    @Override
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();

        int cartID = rs.getInt("id");
        int productId = rs.getInt("productId");
        String productName = rs.getString("name");
        double price = rs.getDouble("price");

        product.setId(productId);
        product.setName(productName);
        product.setPrice(price);
        product.setCartId(cartID);

        cart.setId(cartID);
        if (productName != null) {
            cart.getProductList().add(product);
        }
        return cart;
    }
}