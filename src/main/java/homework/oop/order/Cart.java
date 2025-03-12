package homework.oop.order;

import homework.oop.product.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Cart {
    @Getter
    @Setter
    private Map<Product, Integer> items;
    private static Cart cart;


    public Cart(){
        this.items = new HashMap<>();
    }

    public static Cart getInstance(){
        if(cart == null){
            cart = new Cart();
        }
        return cart;
    }

    public void addProduct(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public void removeProduct(Product product) {
        items.remove(product.equals(product));
    }

    public double getTotalPrice() {
        return items.entrySet().stream().
                mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public void viewCart(){
        System.out.println("Your cart: ");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey().getName() + " : " + entry.getValue());
        }
    }



    /*
    Quản lý giỏ hàng bằng linked list
     */




 /*   public Cart(HashMap<Product, Integer> productQuantity){
        this.productQuantity = productQuantity;
    }

    public HashMap<Product, Integer> getProductQuantity(){
        return productQuantity;
    }

    public int getStock(Product product){
        return products.get(products.indexOf(product)).getStock();
    }




    public void add(Product product, int quantity) {
        this.productQuantity.put(product, this.productQuantity.getOrDefault(product, 0) + quantity);
    }

    public void remove(Product product) {
        this.productQuantity.remove(product);
    }

    public double getTotal() {
        return productQuantity.entrySet().stream().
                mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();


        double total = 0;
        for (Map.Entry<Product, Integer> entry : this.productQuantity.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }



    public void showCart() {
        if (products.isEmpty()) {
            System.out.println("No has items.");
        }
        System.out.println("List of products:");
        for (Product product : products) {
            System.out.println("Name: " + product.getName() + ", Price: " + product.getPrice());
        }
    }

    public void showCart() {
        if (productQuantity.isEmpty()) {
            System.out.println("No cart found");
            return;
        }
        System.out.println("List of products:");
        for (Map.Entry<Product, Integer> entry : productQuantity.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(product.getName() + ", Quantity: " + quantity);
        }
    }

  */
}