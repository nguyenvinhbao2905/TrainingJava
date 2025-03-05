package homework.collection.product;

import lombok.Getter;
import org.antlr.v4.runtime.tree.Tree;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ProductManager {
    private static ProductManager instance;
    @Getter
    private List<Product> products;
    private HashSet<Product> productsSet;
    private TreeMap<Double, List<Product>> productsTreeMap;

    public ProductManager() {
        this.products = new ArrayList<>();
        this.productsSet = new HashSet<>(products);
        this.productsTreeMap = new TreeMap<>();
    }

    public static ProductManager getInstance() {
        if (instance == null) {
            instance = new ProductManager();
        }
        return instance;
    }

    public void addProduct(Product product) {
        //set stock after add
        for (Product p : products) {
            if (p.equals(product)) {
                p.setStock(p.getStock() + product.getStock());
                System.out.println("Product exists, updated stock: " + p);
                return;
            }
        }
        products.add(product);
        productsSet.add(product);

        productsTreeMap.computeIfAbsent(product.getPrice(), k -> new ArrayList<>()).add(product);

        
        System.out.println("Product added: " + product);



//        //Use hashset add product
//        if(!this.productsSet.contains(product)) {
//            this.products.add(product);
//            this.productsSet.add(product);
//            System.out.println("Product added: " + product);
//        } else {
//            System.out.println("Product not added: " + product + " because it has existed");
//        }

        //Use list add product
//        addProducts(Collections.singletonList(product));
//        System.out.println("Product added: " + product.getName());
    }
    public void addProducts(List<Product> newProducts) {
        int addedCount = 0;

        for (Product newProduct : newProducts) {
            boolean exists = false;
            for (Product p : products) {
                if (p.equals(newProduct)) {
                    p.setStock(p.getStock() + newProduct.getStock());
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                this.products.add(newProduct);
                this.productsSet.add(newProduct);
                productsTreeMap.computeIfAbsent(newProduct.getPrice(), k -> new ArrayList<>()).add(newProduct);
                addedCount++;
            }
            
        }

        System.out.println("Added " + addedCount + " new products (existing products updated)");



//        int addedCount = 0;
//
//        Iterator<Product> iterator = products.iterator();
//
//        while(iterator.hasNext()) {
//            Product product = iterator.next();
//            if(!this.productsSet.contains(product)) {
//                this.products.add(product);
//                this.productsSet.add(product);
//                addedCount++;
//            }
//        }
//
//        System.out.println("Added " + addedCount + " products");


//        this.products.addAll(products);
//        System.out.println(products.size() + " products added");
    }

    public void removeProduct(String name) {
        products.removeIf(product -> name.equals(product.getName()));
    }
    public void showProducts() {
        products.forEach(System.out::println);
    }

    public Product getMaxPriceProduct() {
        return products.stream().max(Comparator.comparing(Product::getPrice))
                .orElse(null);
    }

    public void getProductsFromCategory(String category) {
        products.stream().filter(product -> product.getCategory().equals(category))
        .forEach(System.out::println);
    }

    public void sortProductsWithPrice() {
        Collections.sort(products, Comparator.comparing(Product::getPrice));
    }

    public void printCategories() {
        TreeSet<String> categorySet = new TreeSet<>();
        for (Product product : productsSet) {
            categorySet.add(product.getCategory());
        }
        for (String category : categorySet) {
            System.out.println(category);
        }
    }

    public void printProductsByPrice() {
        System.out.println("Product list sorted by price:");
        for (Map.Entry<Double, List<Product>> entry : productsTreeMap.entrySet()) {
            System.out.println("Price: $" + entry.getKey());
            for (Product product : entry.getValue()) {
                System.out.println("  - " + product);
            }
        }
    }

    public TreeMap<Double, List<Product>> getProductsTreeMap(double price) {
        return products.stream().filter(p -> p.getPrice() >= price)
                .collect(Collectors.groupingBy(
                        Product::getPrice,
                        TreeMap::new,
                        Collectors.toList()
                ));
    }




//    public void updateProduct(Product product) {
//        this.products.set(products.indexOf(product), product);
//    }
}
