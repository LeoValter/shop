package ru.leovalter.shop.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.leovalter.shop.ProductTestData;
import ru.leovalter.shop.model.Product;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring/in-memory.xml")
class ProductRepositoryTest {

    @Autowired
    ProductRepository repository;

    @Test
    void shouldAddProduct() {
        Product product = new Product(null, "Iron", "Good Iron", 99.99, 2.4);
        Product actual = repository.save(product);
        Assertions.assertEquals(product, actual);
    }

    @Test
    void shouldFindProductById() {
        Product product = repository.get(ProductTestData.PRODUCT_5.getId());
        Assertions.assertEquals(ProductTestData.PRODUCT_5, product);
    }

    @Test
    void shouldGetAll() {
        List<Product> products = repository.getAll();
        Assertions.assertEquals(10, products.size());
    }

    @Test
    void shouldDeleteProductById() {
        repository.delete(ProductTestData.PRODUCT_5.getId());
        Assertions.assertNull(repository.get(ProductTestData.PRODUCT_5.getId()));
    }

    @Test
    void shouldTrowNotFoundExceptionIfProductNotExist() {
        Product product = new Product(null, "Iron", "Good Iron", 99.99, 2.4);
//        Assertions.assertThrows(NullPointerException.class, () -> repository.delete(product.getId()));
        assertThatNullPointerException().isThrownBy(() -> repository.delete(product.getId()));
    }

}