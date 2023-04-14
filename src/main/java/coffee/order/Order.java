package coffee.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Order {
    private int idOrder;
    private String nameCustomer;
    private List<String> orders = new ArrayList<>();

    public Order(int idOrder, String nameCustomer, String...orders) {
        this.idOrder = idOrder;
        this.nameCustomer = nameCustomer;
        this.orders = Arrays.asList(orders);
    }

    public String getName() {
        return nameCustomer;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setOrderNumber(int orderNumber) {
        this.idOrder = orderNumber;
    }

    public List<String> getOrders() {
        return orders;
    }

    public void setOrders(List<String> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return idOrder + " | " + nameCustomer;
    }

}
