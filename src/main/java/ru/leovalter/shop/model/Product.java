package ru.leovalter.shop.model;

import lombok.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Product extends AbstractNamedEntity {
    private String description;
    private Double price;
    private Double weight;

    public Product(Integer id, String name, String description, Double price, Double weight) {
        super(id, name);
        this.description = description;
        this.price = price;
        this.weight = weight;
    }

    public Product(Product product) {
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getWeight());
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id: " + id +
                ", name: " + name +
                ", description: " + description +
                ", price: " + price +
                ", weight: " + weight +
                '}';
    }

}
