import java.time.LocalDateTime;
import java.util.Objects;

public class Product {
    private String type;
    private double price;
    private boolean discount;
    LocalDateTime dateTime;

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean getDiscount() {
        return discount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Product(String type, double price, boolean discount, LocalDateTime dateTime) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.getPrice(), getPrice()) == 0 &&
                getDiscount() == product.getDiscount() &&
                Objects.equals(getType(), product.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getPrice(), getDiscount());
    }

    @Override
    public String toString() {
        return  "{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", dateTime=" + dateTime +
                '}' + "\n";
    }
}
