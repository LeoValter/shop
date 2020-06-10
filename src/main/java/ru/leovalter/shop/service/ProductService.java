package ru.leovalter.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.leovalter.shop.model.Product;
import ru.leovalter.shop.repository.ProductRepository;
import ru.leovalter.shop.util.ValidationUtil;

import java.util.List;

import static ru.leovalter.shop.util.ValidationUtil.*;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product create(Product product) {
        Assert.notNull(product, "Product must not be null");
        return repository.save(product);
    }

    public Product get(int id) {
        return repository.get(id);
    }

    public Product update(Product product) {
        Assert.notNull(product, "Product must not be null");
        return checkNotFoundWithId(repository.save(product), product.getId());
    }


    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public List<Product> getAll() {
        return repository.getAll();
    }
}
