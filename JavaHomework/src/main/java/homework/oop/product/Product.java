package homework.oop.product;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Product {
    private String name;
    private double price;
    private String category;
    private int stock;

    public Product() {
    }
    public Product(String name, double price, String category, int stock) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }
    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public Product(String name) {
        this.name = name;
    }

    public void showProduct() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Category: " + category);
        System.out.println("Stock: " + stock);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", stock=" + stock +
                '}';
    }
}
