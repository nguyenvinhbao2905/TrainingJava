package homework.collection.product;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class InventoryManager {
    private Map<String, Integer> productsStock;

    public InventoryManager() {
        productsStock = new HashMap<>();
    }

    public void initializeStock() {
        ProductManager productManager = ProductManager.getInstance();
        List<Product> products = productManager.getProducts();
        for (Product product : products) {
            productsStock.put(product.getId(), product.getStock());
        }
    }
    public void printProducts() {
        if (productsStock.isEmpty()) {
            System.out.println("Nothing to print");
            return;
        }
        System.out.println("Products: ");
        productsStock.forEach((id, qty) -> System.out.println(" - Product ID: " + id + ", Quantity: " + qty));
    }
}
