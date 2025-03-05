package homework.collection.user;

import homework.collection.order.Cart;
import homework.collection.order.Review;
import homework.collection.product.Product;
import homework.collection.product.ProductManager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Customer extends User {
    private Set<Product> favoriteProducts;
    private Map<String, Integer> purchasedProducts;
    private int purchaseCount;


    public Customer(String name, String email) {
        super(name, email);
        favoriteProducts = new HashSet<Product>();
        purchasedProducts = new HashMap<String, Integer>();
        this.purchaseCount = 0;
    }

    public void buyProduct(Product product) {
        this.purchasedProducts.put(product.getName(), purchasedProducts.getOrDefault(product.getName(), 0) + 1);
        this.purchaseCount++;
        System.out.println(this.getName() + "  has bought: " + product.getName());
    }

    public int getTotalPurchasedProducts() {
        return purchasedProducts.values().stream().mapToInt(Integer::intValue).sum();
    }

    public void addFavoriteProduct(Product product) {
        if (favoriteProducts.add(product)) {
            System.out.println(product.getName() + " has been added to favorites.");
        } else {
            System.out.println(product.getName() + " is already in favorites.");
        }
    }
    public boolean isFavoriteProduct(Product product) {
        return favoriteProducts.contains(product);
    }

    public void showFavoriteProducts() {
        if (favoriteProducts.isEmpty()) {
            System.out.println("No favorite products");
            return;
        }
        System.out.println("Favorite products of " + super.getName() + ":");
        for (Product product : favoriteProducts) {
            System.out.println(" " + product);
        }
    }


}
