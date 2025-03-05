package homework.collection.user;

import homework.collection.order.Order;
import homework.collection.product.Product;
import homework.collection.product.ProductManager;


public class Admin extends User {

    public Admin(String name, String email, String password) {
        super(name, email, password);
        permissions.add(Permission.MANAGE_PRODUCTS);
        permissions.add(Permission.MANAGE_ORDERS);
    }

    public void addProduct(Product product) {
        if(permissions.contains(Permission.MANAGE_PRODUCTS)) {
            ProductManager.getInstance().addProduct(product);
        }
        System.out.println("Permission denied!!");
    }
//    public void removeProduct(Product product) {
//        if(permissions.contains(Permission.MANAGE_PRODUCTS)) {
//            ProductManager.getInstance().removeProduct(product);
//        }
//        System.out.println("Permission denied!!");
//    }

    public void getProducts() {
        System.out.println("Viewing products");
        for (Product product : ProductManager.getInstance().getProducts()) {
            System.out.println(product);
        }
    }
    public void approveOrder(Order order) {
        order.updateStatus(Order.OrderStatus.SHIPPED);
        System.out.println("Admin approved order and shipped: " + order.getOrderId());
    }

    @Override
    public void showPermissions() {
        System.out.println("Admin permissions: " + permissions);
    }
}
