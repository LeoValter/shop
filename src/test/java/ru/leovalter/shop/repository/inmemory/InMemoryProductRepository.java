package ru.leovalter.shop.repository.inmemory;

import org.springframework.stereotype.Repository;
import ru.leovalter.shop.ProductTestData;
import ru.leovalter.shop.model.Product;
import ru.leovalter.shop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository extends InMemoryBaseRepository<Product> implements ProductRepository {

    {
        map.clear();
        ProductTestData.PRODUCTS.forEach(product -> map.put(product.getId(), product));
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(getCollections());
    }

}
