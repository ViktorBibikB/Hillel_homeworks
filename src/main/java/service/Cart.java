package service;

import model.Product;

public interface Cart {

    void add(Product product);

    void remove(int id);
}