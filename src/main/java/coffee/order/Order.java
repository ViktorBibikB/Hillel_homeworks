package coffee.order;

import java.util.Objects;

public class Order implements Comparable<Order>{
    private int orderNumber;
    private String clientName;

    public Order(String clientName) {
        this.clientName = clientName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getOrderNumber() == order.getOrderNumber() &&
                Objects.equals(getClientName(), order.getClientName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderNumber(), getClientName());
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", clientName='" + clientName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Order o) {
        return this.orderNumber - o.orderNumber;
    }
}
