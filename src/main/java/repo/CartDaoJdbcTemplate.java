package repo;

import config.CartRowMapper;
import model.Cart;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Statement;

@Component
public class CartDaoJdbcTemplate implements CartDao {

    private JdbcTemplate jdbcTemplate;

    public CartDaoJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void remove(Cart cart) {
        String sqlRemove = "DELETE FROM carts WHERE id = ?";
        jdbcTemplate.update(sqlRemove, cart.getId());
    }

    @Override
    public Cart add(Cart cart) {
        String sqlInsert = "INSERT INTO carts VALUES()";

        Cart cartChecked;
        try {
            cartChecked = getById(cart.getId());
        } catch (EmptyResultDataAccessException e) {
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(connection -> connection.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS), keyHolder);
            int id = keyHolder.getKey().intValue();
            cart.setId(id);
            return cart;
        }
        return cartChecked;
    }

    @Override
    public Cart getById(int id) {
        String sqlGetById = "SELECT products.id as productId, products.name, products.price, carts.id" +
                                 "FROM products" +
                                 "RIGHT JOIN carts ON products.cart_id = carts.id" +
                                 "where carts.id = ?";
        return jdbcTemplate.query(sqlGetById, new CartRowMapper(), id).stream().findFirst().get();
    }

}