package models;

public class Product {
    public int productId;
    public String name;
    public String category;
    public double price;
    public String brand;

    public Product(int productId, String name, String category, double price, String brand) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.brand = brand;
    }
}

