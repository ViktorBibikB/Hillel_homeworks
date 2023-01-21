import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ProductManager {
    private List<? extends Product> product;

    public ProductManager(List<? extends Product> product) {
        this.product = product;
    }

    public List<? extends Product> getProduct() {
        return product.stream()
                .filter(ProductManager::isBook)
                .filter((product) -> product.getPrice() > 250)
                .peek((p) -> System.out.println(p.getType() + " / " + p.getPrice()))
                .collect(Collectors.toList());
    }

    public List<? extends Product> getProductsWithDiscount() {
        return product.stream()
                .filter(ProductManager::isBook)
                .filter(Product::getDiscount)
                .map((product) -> new Product(product.getType()
                        , product.getPrice() * 0.9
                        , product.getDiscount()
                        , product.getDateTime()))
                .peek((p) -> System.out.println("Price with discount: " + p.getType() + " / " + p.getPrice()))
                .collect(Collectors.toList());
    }

    public Product getMinPriceProduct() {
        return product.stream()
                .filter(ProductManager::isBook)
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Product [category:Book] is not found."));
    }

    public List<? extends Product> getTreeNewAddedProducts() {
        return product.stream()
                .sorted(Comparator.comparing(Product::getDateTime, Comparator.reverseOrder()))
                .limit(3)
                .peek((product) -> System.out.println(product.getType() + " / " + product.getPrice() +
                        " / " + product.getDateTime()))
                .collect(Collectors.toList());
    }

    public double getTotalSumCurrentYearProducts() {
        return product.stream()
                .filter(ProductManager::isBook)
                .filter((product) -> product.getDateTime().getYear() >= LocalDateTime.now().getYear())
                .filter((product) -> product.getDateTime().getMonth().compareTo(LocalDateTime.now().getMonth()) <= 0)
                .filter((product) -> product.getPrice() <= 75.0)
                .peek((p) -> System.out.println(p.getDateTime() + " / " + p.getType() + " / " + p.getPrice()))
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public Map<String, List<Product>> groupProductsByCategory() {
        return product.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }

    private static Product setDiscount(Product product) {
        double discountedPrice = product.getPrice() * 0.9;
        return new Product(product.getType()
                , discountedPrice
                , product.getDiscount()
                , product.getDateTime());
    }

    private static boolean isBook(Product product) {
        return product.getType().equals("Book");
    }
}
