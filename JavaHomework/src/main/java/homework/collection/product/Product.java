package homework.collection.product;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;


@Getter
@Setter
public class Product {
    private String name;
    private double price;
    private String category;
    private int stock;
    private String id;
    private static final AtomicInteger index = new AtomicInteger(1);

    public Product() {
        this.assignId();
    }
    public Product(String name, double price, String category, int stock) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.assignId();
    }
    public Product(String name, double price, String category) {
        this(name, price, category, 0);
    }

    public Product(String name, double price) {
        this(name, price, "Uncategorized");
    }

    public Product(String name) {
        this(name, 0.0);
    }

    public void showProduct() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Category: " + category);
        System.out.println("Stock: " + stock);
    }
    public void assignId() {

        this.id = "Product-" + index.getAndIncrement();
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", stock=" + stock +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name) && category.equals(product.category) && Double.compare(price, product.price) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, category, price);
    }
}
