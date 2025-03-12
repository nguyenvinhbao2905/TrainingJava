package homework.collection.order;

import homework.collection.product.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.*;


public class Cart {
    @Getter
    @Setter
    private Map<Product, Integer> items;
    private List<Product> products;
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



/* Bai 7 su dung linked list
    public Cart() {
        this.products = new LinkedList<>();
    }

    public void addProduct(Product product) {
        addProducts(Collections.singletonList(product));

        System.out.println("Product added: " + product);
    }

    public void addProducts(List<Product> products) {
        this.products.addAll(products);

        System.out.println(products.size() + " products added");
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public Product getFirstProduct() {
        return products.isEmpty() ? null : products.getFirst();
    }
    public Product getLastProduct() {
        return products.isEmpty() ? null : products.getLast();
    }
*/


}