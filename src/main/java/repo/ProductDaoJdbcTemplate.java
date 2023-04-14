package repo;

import config.ProductRowMapper;
import lombok.Data;
import model.Product;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Data
@Component
public class ProductDaoJdbcTemplate implements ProductDao {
    private JdbcTemplate jdbcTemplate;

    public ProductDaoJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void remove(Product product) {
        String sqlDelete = "DELETE FROM products WHERE name = ? AND price = ?";
        jdbcTemplate.update(sqlDelete, product.getName(), product.getPrice());
    }

    @Override
    public Product add(Product product) {
        String sqlCheck = "SELECT * FROM products WHERE name = ? AND price = ?";
        Product productChecked;
        try {
            productChecked = jdbcTemplate.queryForObject(sqlCheck, new ProductRowMapper(), product.getName(), product.getPrice());
        } catch (EmptyResultDataAccessException e) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            String sqlInsert = "INSERT INTO products(name, price, cart_id) VALUES(?, ?, ?)";
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, product.getName());
                ps.setDouble(2, product.getPrice());
                ps.setInt(3, product.getCartId());
                return ps;
            }, keyHolder);
            int id = keyHolder.getKey().intValue();
            product.setId(id);
            return product;
        }
        return productChecked;
    }

    @Override
    public Product getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM products WHERE id=?", new ProductRowMapper(), id);
    }

    @Override
    public List<Product> getAll() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }
}