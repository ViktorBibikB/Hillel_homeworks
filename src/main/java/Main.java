import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Book", 28, true, LocalDateTime.parse("2023-01-15T14:33:25")));
        products.add(new Product("Book", 251, false, LocalDateTime.parse("2022-12-15T14:32:45")));
        products.add(new Product("Book", 350,false, LocalDateTime.parse("2023-01-13T15:33:14")));
        products.add(new Product("Book", 250, true, LocalDateTime.parse("2023-01-16T10:33:32")));
        products.add(new Product("Box", 256, false, LocalDateTime.parse("2021-01-15T14:33:35")));
        products.add(new Product("NoteBook", 56, true, LocalDateTime.parse("2023-01-17T14:33:42")));
        products.add(new Product("Phone", 367, true, LocalDateTime.parse("2023-01-17T14:33:42")));
        products.add(new Product("Phone", 74, true, LocalDateTime.parse("2023-01-14T15:34:42")));
        products.add(new Product("PC", 854, true, LocalDateTime.parse("2023-01-18T14:34:42")));
        products.add(new Product("Laptop", 1367, true, LocalDateTime.parse("2023-01-17T14:33:43")));
        products.add(new Product("Book", 68, true, LocalDateTime.parse("2023-01-12T11:32:21")));
        products.add(new Product("Book", 37, true, LocalDateTime.parse("2023-01-19T15:33:25")));
        products.add(new Product("Book", 17, true, LocalDateTime.parse("2022-12-31T23:59:59")));
        products.add(new Product("Book", 18, true, LocalDateTime.parse("2023-02-15T23:59:59")));

        System.out.println(products);

        ProductManager productManager = new ProductManager(products);
        productManager.getProduct();

        System.out.println();
        productManager.getProductsWithDiscount();

        System.out.println();
        System.out.println("Min price product: " + productManager.getMinPriceProduct().getType() + " / " +
                productManager.getMinPriceProduct().getPrice());

        System.out.println();
        productManager.getTreeNewAddedProducts();

        System.out.println();
        System.out.println("Particular year added products with type Book - sum is: " + productManager.getTotalSumCurrentYearProducts());

        System.out.println();
        System.out.println(productManager.groupProductsByCategory());
    }
}
