package homework.collection.order;

import homework.collection.product.Product;
import homework.collection.user.User;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Order {
    private int orderId;
    private User user;
    private HashMap<Product, Integer> products;
    private double totalPrice;
    private OrderStatus orderStatus;

    public enum OrderStatus {
            PROCESSING, SHIPPED, CANCELLED;
    }
    public Order() {}

    public Order(int orderId, User user, HashMap<Product, Integer> products, double totalPrice) {
        this.orderId = orderId;
        this.user = user;
        this.products = new HashMap<>(products);
        this.totalPrice = totalPrice;
        this.orderStatus = OrderStatus.PROCESSING;
    }
    public Order (int orderId, User user, HashMap<Product, Integer> products) {
        this.orderId = orderId;
        this.user = user;
        this.products = new HashMap<>(products);
    }

    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No cart found");
            return;
        }
        System.out.println("List of products your order: ");
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(product + ", Quantity: " + quantity);
        }
    }
    public boolean updateStatus(OrderStatus newStatus) {
        if (this.orderStatus == null) {
            System.out.println("Order status is not initialized.");
            return false;
        }

        if (this.orderStatus == OrderStatus.CANCELLED) {
            System.out.println("Cannot change status of a cancelled order!!!");
            return false;
        }
        if (this.orderStatus == OrderStatus.PROCESSING && newStatus == OrderStatus.SHIPPED) {
            this.orderStatus = newStatus;
            System.out.println("Order status updated to: " + this.orderStatus);
            return true;
        }

        System.out.println("Invalid status transition!");
        return false;
    }

}
