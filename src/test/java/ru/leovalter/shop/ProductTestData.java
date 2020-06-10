package ru.leovalter.shop;

import ru.leovalter.shop.model.Product;

import java.util.List;

import static ru.leovalter.shop.model.AbstractBaseEntity.START_SEQUENCE;

public class ProductTestData {

    public static final Integer PRODUCT_ID = START_SEQUENCE + 2;

    public static final Product PRODUCT_1 = new Product(PRODUCT_ID, "Product 1", "Description about product 1", 1.1, 11.1);
    public static final Product PRODUCT_2 = new Product(PRODUCT_ID + 1, "Product 2", "Description about product 2", 1.2, 11.2);
    public static final Product PRODUCT_3 = new Product(PRODUCT_ID + 2, "Product 3", "Description about product 3", 1.3, 11.3);
    public static final Product PRODUCT_4 = new Product(PRODUCT_ID + 3, "Product 4", "Description about product 4", 1.4, 11.4);
    public static final Product PRODUCT_5 = new Product(PRODUCT_ID + 4, "Product 5", "Description about product 5", 1.5, 11.5);
    public static final Product PRODUCT_6 = new Product(PRODUCT_ID + 5, "Product 6", "Description about product 6", 1.6, 11.6);
    public static final Product PRODUCT_7 = new Product(PRODUCT_ID + 6, "Product 7", "Description about product 7", 1.7, 11.7);
    public static final Product PRODUCT_8 = new Product(PRODUCT_ID + 7, "Product 8", "Description about product 8", 1.8, 11.8);
    public static final Product PRODUCT_9 = new Product(PRODUCT_ID + 8, "Product 9", "Description about product 9", 1.9, 11.9);
    public static final Product PRODUCT_10 = new Product(PRODUCT_ID + 9, "Product 10", "Description about product 10", 1.10, 11.10);

    public static final List<Product> PRODUCTS = List.of(PRODUCT_1, PRODUCT_2, PRODUCT_3, PRODUCT_4, PRODUCT_5, PRODUCT_6, PRODUCT_7, PRODUCT_8, PRODUCT_9, PRODUCT_10);

    public static Product getNew() {
        return new Product(null, "New Product", "This is new Product", 100.00, 20.00);
    }
}
