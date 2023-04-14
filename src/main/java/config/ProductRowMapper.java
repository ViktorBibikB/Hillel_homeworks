package config;

import model.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int price = rs.getInt("price");
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        return product;
    }
}
