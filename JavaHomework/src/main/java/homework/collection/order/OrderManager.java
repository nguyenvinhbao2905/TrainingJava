package homework.collection.order;

import homework.collection.product.Product;
import homework.collection.user.User;

import java.util.*;

public class OrderManager {
    private LinkedHashSet<Order> completedOrders;
    private Map<Order, List<Product>> orderProducts;
    private HashMap<User, Integer> purchaseCounts;
    private HashMap<Product, Integer> productOrderCounts;

    public OrderManager() {
        completedOrders = new LinkedHashSet<>();
        orderProducts = new LinkedHashMap<>();
        purchaseCounts = new HashMap<>();
        productOrderCounts = new HashMap<>();
    }


    public void completeOrder(Order order) {
        if (order.getOrderStatus() == Order.OrderStatus.PROCESSING) {
            order.updateStatus(Order.OrderStatus.SHIPPED);
            completedOrders.add(order);

            orderProducts.computeIfAbsent(order, k -> new ArrayList<>());

            User customer = order.getUser();
            purchaseCounts.put(customer, purchaseCounts.getOrDefault(customer, 0) + 1);

            for (Map.Entry<Product, Integer> entry : order.getProducts().entrySet()) {
                Product product = entry.getKey();
                Integer quantity = entry.getValue();
                productOrderCounts.put(product, productOrderCounts.getOrDefault(product, 0) + quantity);
            }


            System.out.println("Order completed: " + order.getOrderId());
        } else {
            System.out.println("Order " + order.getOrderId() + " is not in PROCESSING state!");
        }
    }

    public int getTotalOrdersForProduct(Product product) {
        return productOrderCounts.getOrDefault(product, 0);
    }

    public void printTopProductsOrders() {
        productOrderCounts.entrySet().stream()
                        .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                                .limit(5)
                                        .forEach(entry ->
                                                System.out.println(entry.getKey()
                                                        + " has been ordered " + entry.getValue() + " times."));
    }

    public int getTotalPurchase(User user) {
        return purchaseCounts.getOrDefault(user, 0);
    }

    public void printPurchaseCount() {
        purchaseCounts.forEach((user, purchaseCount) ->
                System.out.println(user.getName() + " has been bought " + purchaseCount + " times."));
    }
    public void findUserPurchasesMaxTimes() {
        if (purchaseCounts.isEmpty()) {
            System.out.println("No orders have been processed!");
            return;
        }
        Map.Entry<User, Integer> maxTime = purchaseCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        if (maxTime != null) {
            System.out.println("The most buying customers: "
                    + maxTime.getKey().getName() + " - " + maxTime.getValue() + " times.");
        }
    }
    public void showCompletedOrders() {
        if (completedOrders.isEmpty()) {
            System.out.println("No orders completed!");
            return;
        }
        for (Order o : completedOrders) {
            System.out.println("OrderId: " + o.getOrderId() + ", Status: " + o.getOrderStatus());
            List<Product> products = orderProducts.get(o);


            if (products != null && !products.isEmpty()) {
                System.out.println("    Products: ");
                for (Product p : products) {
                    System.out.println("     - " + p.getName());
                }
            }
        }
    }

    public List<Product> getOrderProducts(Order order) {
        return orderProducts.getOrDefault(order, new ArrayList<>());
    }
    public void addOrderProduct(Order order, Product product) {
        if (order.getOrderStatus() != Order.OrderStatus.PROCESSING) {
            System.out.println("Cannot add product to an order that is not in PROCESSING state.");
            return;        }

        orderProducts.computeIfAbsent(order, k -> new ArrayList<>()).add(product);
        System.out.println("Added product " + product.getName() + " to order " + order.getOrderId());

    }

    public void printAllOrders() {
        if (orderProducts.isEmpty()) {
            System.out.println("No orders available!");
            return;
        }
        orderProducts.forEach((order, products) -> {
            System.out.println("Order ID: " + order.getOrderId());
            if (!products.isEmpty()) {
                products.forEach(product -> System.out.println(" - " + product.getName()));
            } else {
                System.out.println(" - No products in this order.");
            }
        });
    }



}
