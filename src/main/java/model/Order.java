package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private Date date;
    private double cost;
    private List<Product> productList = new ArrayList<>();

    public Order(int id, Product... products) {
        this.id = id;
        this.date = new Date();
        productList.addAll(Arrays.asList(products));
        this.cost = 0;
    }


    public void add(Product product) {
        productList.add(product);
        this.cost += product.getCost();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", cost=" + cost +
                ", productList=" + productList +
                '}';
    }

    public Order() {
        this.date = new Date();
    }
}
