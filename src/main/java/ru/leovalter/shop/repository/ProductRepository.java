package ru.leovalter.shop.repository;

import ru.leovalter.shop.model.Product;

import java.util.List;

public interface ProductRepository {

    Product save(Product product);

    Product get(int id);

    List<Product> getAll();

    boolean delete(int id);
}
