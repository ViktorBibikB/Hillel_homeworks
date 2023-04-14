import model.Cart;
import model.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repo.CartDao;
import repo.ProductDao;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("demo");

        ProductDao productDao = applicationContext.getBean(ProductDao.class);
        CartDao cartDao = applicationContext.getBean(CartDao.class);

        Cart cart1 = new Cart();
        cart1.setId(1);
        Cart cart2 = new Cart();
        cart2.setId(2);

        Product product1 = new Product();
        product1.setName("Product_1");
        product1.setPrice(13);
        product1.setCartId(1);
        Product product2 = new Product();
        product2.setName("Product_2");
        product2.setPrice(14.4);
        product2.setCartId(1);

        System.out.println(cartDao.add(cart1));
        System.out.println(cartDao.add(cart2));

        productDao.add(product1);
        productDao.add(product2);

        productDao.remove(product2);
        System.out.println(cartDao.getById(1));

        applicationContext.close();
    }
}
