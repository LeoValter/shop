package ru.leovalter.shop.model;

public class Product extends AbstractNamedEntity {
    private String description;
    private Double price;
    private Double weight;

    public Product() {
    }

    public Product(Integer id, String name, String description, Double price, Double weight) {
        super(id, name);
        this.description = description;
        this.price = price;
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + "description: (" + description + "), price: " + price
                + ", weight: " + weight + " kg.";
    }
}
