package homework.oop.product;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static ProductManager instance;
    private List<Product> products;
    private ProductManager() {
        this.products = new ArrayList<>();
    }

    public static ProductManager getInstance() {
        if (instance == null) {
            instance = new ProductManager();
        }
        return instance;
    }
    public void addProduct(Product product) {
        this.products.add(product);
        System.out.println("Product added: " + product.getName());
    }
    public List<Product> getProducts() {
        return products;
    }
    public void removeProduct(Product product) {
        this.products.remove(product);
    }

//    public void updateProduct(Product product) {
//        this.products.set(products.indexOf(product), product);
//    }
}
