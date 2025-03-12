package homework.oop.product;

import homework.oop.order.Order;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private HashMap<Product, Integer> products;

    public Inventory() {}

    public Inventory(HashMap<Product, Integer> products) {
        this.products = new HashMap<>(products);
    }


    public int checkStock(Product product) {
        if (!products.containsKey(product)) {
            throw new IllegalArgumentException("Product does not exist");
        }
        return products.get(product);
    }

    public void restock (Product product, int quantity) {
        this.products.put(product, this.products.getOrDefault(product, 0) + quantity);
    }
    public void detectStock(Order order) {
        if (order.getOrderStatus().equals(Order.OrderStatus.PROCESSING)) {
            for (Map.Entry<Product, Integer> entry : order.getProducts().entrySet()) {
                Product product = entry.getKey();
                Integer quantity = entry.getValue();

                if (products.getOrDefault(product, 0) < quantity) {
                    throw new IllegalArgumentException("Not enough stock");
                }
                products.put(product, products.get(product) - quantity);
            }
            order.updateStatus(Order.OrderStatus.SHIPPED);
        }
    }

}
