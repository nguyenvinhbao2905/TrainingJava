package homework.collection.test;

import homework.collection.order.Order;
import homework.collection.order.OrderManager;
import homework.collection.order.Review;
import homework.collection.order.ReviewManager;
import homework.collection.product.CategoryManager;
import homework.collection.product.InventoryManager;
import homework.collection.product.Product;
import homework.collection.product.ProductManager;
import homework.collection.search.SearchHistoryManager;
import homework.collection.user.Customer;
import homework.collection.user.User;
import homework.collection.user.UserRegistry;

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        testProduct();
//        testUser();
//        testCustomer();
//        testInventoryManager();

//        testReview();
        testOrderManager();
    }


    public static void testProduct(){
        ProductManager productManager = new ProductManager();

        productManager.addProduct(new Product("Laptop Dell XPS 15", 1599.99, "Electronics", 10));
        System.out.println("List product after add a product: ");
        productManager.showProducts();

        List<Product> products = new ArrayList<>();

        products.add(new Product("Smartphone", 799.99, "Electronics", 50));
        products.add(new Product("Laptop", 1299.99, "Electronics", 30));
        products.add(new Product("Wireless Headphones", 199.99, "Electronics", 100));
        products.add(new Product("Nike Air Max 270", 129.99, "Footwear", 25));
        products.add(new Product("Samsung Galaxy S23", 999.99, "Mobile Phones", 15));
        products.add(new Product("Sony WH-1000XM5 Headphones", 399.99, "Accessories", 30));
        products.add(new Product("Apple iPad Pro 12.9", 1199.99, "Tablets", 12));
        products.add(new Product("Laptop", 1299.99, "Electronics", 30));



        System.out.println("\nList product after add products: ");
        productManager.addProducts(products);
        productManager.showProducts();

        productManager.removeProduct("Nike Air Max 270");
        System.out.println("List product after remove a product: ");
        productManager.showProducts();

        System.out.println("Product has max price:");
        productManager.getMaxPriceProduct().showProduct();


        System.out.println("Product from category;");
        productManager.getProductsFromCategory("Electronics");


        productManager.sortProductsWithPrice();
        System.out.println("Product after sorting products: ");
        productManager.showProducts();


        productManager.printCategories();

        productManager.printProductsByPrice();

        double targetPrice = 999.99;
        TreeMap<Double, List<Product>> result = productManager.getProductsTreeMap(targetPrice);

        if (result.containsKey(targetPrice)) {
            System.out.println("Price: " + targetPrice);
            result.get(targetPrice).forEach(product ->
                    System.out.println(" - " + product.getName()));
        } else {
            System.out.println("No products found at price: " + targetPrice);
        }
    }

    public static void testUser() {
        UserRegistry user = new UserRegistry();
        user.addUser(new User("example@example.com"));

        user.checkEmail("example@example.com"); // In: "Email is existed"


        user.checkEmail("abc@example.com"); // In: "Email is not existed"
    }
    public static void testCustomer() {
        Customer customer = new Customer("Bao", "hfofhaofhosa");
        List<Product> products = new ArrayList<>();

        products.add(new Product("Smartphone", 799.99, "Electronics", 50));
        products.add(new Product("Laptop", 1299.99, "Electronics", 30));
        products.add(new Product("Wireless Headphones", 199.99, "Electronics", 100));
        products.add(new Product("Nike Air Max 270", 129.99, "Footwear", 25));
        products.add(new Product("Samsung Galaxy S23", 999.99, "Mobile Phones", 15));
        products.add(new Product("Sony WH-1000XM5 Headphones", 399.99, "Accessories", 30));
        products.add(new Product("Apple iPad Pro 12.9", 1199.99, "Tablets", 12));
        products.add(new Product("Laptop", 1299.99, "Electronics", 30));


        customer.addFavoriteProduct(products.get(0));
        customer.addFavoriteProduct(products.get(1));
        customer.addFavoriteProduct(products.get(2));
        customer.addFavoriteProduct(products.get(3));


        // Check favorite product in list
        System.out.println("\nCheck if 'Smartphone' is favorite:");
        boolean isFav = customer.isFavoriteProduct(new Product("Smartphone", 800.0));
        System.out.println(isFav ? "Yes, it's in favorites." : "No, it's not in favorites.");

        // Print all favorite product
        System.out.println("\nCustomer's favorite products:");
        customer.showFavoriteProducts();


        Customer newCustomer = new Customer("Bao", "hiugiuiuiu");
        Product laptop = new Product("Laptop", 1299.99, "Electronics", 30);
        Product phone = new Product("Smartphone", 799.99, "Electronics", 50);

        customer.buyProduct(laptop);
        customer.buyProduct(phone);
        customer.buyProduct(laptop);
        System.out.println(customer.getName() + " has made a total of " + customer.getTotalPurchasedProducts() + " purchases.");

    }

    public static void testInventoryManager() {
        InventoryManager inventoryManager = new InventoryManager();
        ProductManager productManager = ProductManager.getInstance();


        productManager.addProduct(new Product("Laptop", 1000, "Electronics", 10));
        productManager.addProduct(new Product("Phone", 500, "Mobile", 20));

        inventoryManager.initializeStock();
        inventoryManager.printProducts();;
    }

    public static void testReview() {
        ReviewManager reviewManager = new ReviewManager();

        User alice = new User("Alice", "alice@example.com");
        User bob = new User("Bob", "bob@example.com");

        Product laptop = new Product("MacBook Pro", 1999.99, "Electronics");
        Product phone = new Product("iPhone 15", 999.99, "Mobile Phones");
        Product headphones = new Product("Sony WH-1000XM5", 399.99, "Accessories");

        reviewManager.addReview(alice, new Review(alice, laptop, 5, "Amazing performance!"));
        reviewManager.addReview(alice, new Review(alice, phone, 4, "Great but expensive."));
        reviewManager.addReview(bob, new Review(bob, headphones, 3, "Sound quality is decent."));

        System.out.println("\nReviews by Alice:");
        for (Review review : reviewManager.getReviewByUser(alice)) {
            System.out.println("  - " + review);
        }

        System.out.println("\nAll Reviews:");
        reviewManager.printAllReview();
    }

    public static void testOrderManager() {

    }

    public static void testCategoryManager() {
        CategoryManager manager = new CategoryManager();

        manager.addSubcategory("Electronics", "Phone");
        manager.addSubcategory("Electronics", "Laptop");
        manager.addSubcategory("Fashion", "Clothing");
        manager.addSubcategory("Fashion", "Shoes");

        manager.printCategories();

        System.out.println("Subcategories of Electronics: " + manager.getSubcategories("Electronics"));

    }

    public static void testSearchHistory() {
        SearchHistoryManager searchManager = new SearchHistoryManager();

        searchManager.addSearch("Dell Laptop");
        searchManager.addSearch("iPhone");
        searchManager.addSearch("Bluetooth Headphones");
        searchManager.addSearch("Samsung Tablet");
        searchManager.addSearch("Smartwatch");
        searchManager.addSearch("Dash Camera");
        searchManager.addSearch("Bluetooth Speaker");
        searchManager.addSearch("Mechanical Keyboard");
        searchManager.addSearch("Gaming Mouse");
        searchManager.addSearch("Sony TV");
        searchManager.addSearch("Canon Camera"); // History is full, will be removed

        searchManager.printHistory();
    }


}
