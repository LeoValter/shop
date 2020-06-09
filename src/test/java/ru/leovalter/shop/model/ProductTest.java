package ru.leovalter.shop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.leovalter.shop.ProductTestData.PRODUCT_1;
import static ru.leovalter.shop.ProductTestData.PRODUCT_5;

class ProductTest {

    @Test
    void shouldCreateNewProductWithoutArgs() {
        new User();
    }

    @Test
    void shouldCreateNewProductWithAllArgs() {
        new Product(PRODUCT_1.getId(), PRODUCT_1.getName(), PRODUCT_1.getDescription(), PRODUCT_1.getPrice(),PRODUCT_1.getWeight());
    }

    @Test
    void testGetters() {
        Product product = PRODUCT_5;
        assertEquals(PRODUCT_5.getId(), product.getId());
        assertEquals(PRODUCT_5.getName(), product.getName());
        assertEquals(PRODUCT_5.getDescription(), product.getDescription());
        assertEquals(PRODUCT_5.getPrice(), product.getPrice());
        assertEquals(PRODUCT_5.getWeight(), product.getWeight());
    }

    @Test
    void testSetters() {
        Product product = new Product();
        product.setId(3333);
        assertEquals(3333, product.getId());
        //TODO other
    }

    @Test
    void testToString() {
        //TODO test
    }
}