package homework.oop.user;

import homework.oop.order.Cart;
import homework.oop.product.Product;
import homework.oop.order.Review;
import homework.oop.product.ProductManager;

public class Customer extends User{

    public Customer(String name, String email, String password) {
        super(name, email, password);
        permissions.add(Permission.PURCHASE_ITEMS);
        permissions.add(Permission.WRITE_REVIEWS);
    }

    public void getProductsInProductManager() {
        System.out.println("Viewing products");
        for (Product product : ProductManager.getInstance().getProducts()) {
            System.out.println(product);
        }
    }

    public void getProductInYourCart() {
        if (permissions.contains(Permission.PURCHASE_ITEMS)) {
            System.out.println("Viewing products in your cart");
            Cart.getInstance().viewCart();
        }
        System.out.println("Permission denied!!");
    }

    public void addProductToYourCart(Product product, int quantity) {
        if (permissions.contains(Permission.PURCHASE_ITEMS)) {
            System.out.println("Adding product to your cart");
            Cart.getInstance().addProduct(product, quantity);
        }
        System.out.println("Permission denied!!");
    }
    public void removeProductFromYourCart(Product product) {
        if (permissions.contains(Permission.PURCHASE_ITEMS)) {
            System.out.println("Removing product from your cart");
            Cart.getInstance().removeProduct(product);
        }
        System.out.println("Permission denied!!");
    }

    public void writeReview(Product product, int rating, String comment) {
        Review review = new Review(this, product, rating, comment);
        System.out.println(this.getName() + "wrote review for " + product);
    }
    @Override
    public void showPermissions() {
        System.out.println("Customer's permissions: " + permissions);
    }


}
