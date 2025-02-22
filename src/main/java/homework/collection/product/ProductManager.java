package homework.collection.product;

import lombok.Getter;
import org.antlr.v4.runtime.tree.Tree;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductManager {
    private static ProductManager instance;
    @Getter
    private List<Product> products;
    private HashSet<Product> productsSet;

    public ProductManager() {
        this.products = new ArrayList<>();
        this.productsSet = new HashSet<>();
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
        this.products.add(product);
        this.productsSet.add(product);
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
        products.removeIf(product -> product.getName().equals(name));
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
    public void assignIds(List<Product> products) {
        AtomicInteger index = new AtomicInteger(1);
        products.forEach(product -> product.setId(index.getAndIncrement()));
    }


//    public void updateProduct(Product product) {
//        this.products.set(products.indexOf(product), product);
//    }
}
