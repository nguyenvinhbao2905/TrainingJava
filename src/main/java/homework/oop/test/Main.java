package homework.oop.test;

import homework.oop.order.Cart;
import homework.oop.order.Order;
import homework.oop.order.Review;
import homework.oop.payment.CreditCardPayment;
import homework.oop.payment.PaypalPayment;
import homework.oop.product.Discount;
import homework.oop.product.Inventory;
import homework.oop.product.Product;
import homework.oop.user.Admin;
import homework.oop.user.Customer;
import homework.oop.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("------------------ test Product");
        testProduct();
        System.out.println("------------------ test User");
        testUser();
        System.out.println("------------------ testCart");
        testCart();
        System.out.println("------------------ testOrder");
        testOrder();
        System.out.println("------------------ testReview");
        testReview();
        System.out.println("------------------ testPayment");
        testPayment();
        System.out.println("------------------ testDiscount");
        testDiscount();
        System.out.println("------------------ testInventory");
        testInventory();
        System.out.println("------------------ testCustomerAndAdmin");
        testCustomerAndAdmin();
        System.out.println("------------------ test User");
    }
    public static void testProduct(){
        Product p = new Product("Dien thoai", 250, "Thiet bi dien tu", 30);
        p.showProduct();
    }
    public static void testUser(){
        User user = new User("bao", "bao@", "12345");
        user.displayUser();
        System.out.println("Enter your password again: ");
        String password = sc.nextLine();
        System.out.println(user.checkPassWordUseBCrypt(password));
    }
    public static void testCart() {
        Product p = new Product("Dien thoai", 260, "Thiet bi dien tu");
        Product p1 = new Product("Dien thoai ban", 200, "Thiet bi dien tu");

        Cart cart = new Cart();
        cart.addProduct(p, 10);
        cart.addProduct(p1, 20);
        System.out.println(cart.getTotalPrice());
//        System.out.println(cart.getStock(p1));


    }

    public static void testOrder() {
        Order order = new Order();
        order.setOrderStatus(Order.OrderStatus.PROCESSING);

        System.out.println(order.getOrderStatus());
        order.updateStatus(Order.OrderStatus.PROCESSING);
        order.updateStatus(Order.OrderStatus.CANCELLED);



    }

    public static void testReview(){
        Product p = new Product("Dien thoa", 1500);
        User u = new User("bao", "bao@");

        Review rv = new Review(u, p, 5, "San pham tot");
        rv.showReview();

    }

    public static void testPayment(){
        CreditCardPayment cr = new CreditCardPayment("10537539", "bao", "20/05/2025", 150000);
        cr.processPayment(1000);

        PaypalPayment pp = new PaypalPayment("bao", 150000);
        pp.processPayment(10000);

    }

    public static void testDiscount(){
        Product p = new Product("Dien thoai", 260, "Thiet bi dien tu");
        Product p1 = new Product("Dien thoai", 2500, "Thiet bi dien tu");
        Cart cart = new Cart();
        cart.addProduct(p, 10);
        Discount dc = new Discount();
        dc.applyDiscount(p, 10);
        System.out.println("Product price after discount: " + p.getPrice());


        List<Product> list = new ArrayList<>();
        list.add(p);
        list.add(p1);

        Cart cart1 = new Cart();

        dc.applyBulkDiscount(cart1, 1, 15);
        System.out.println("The total value of the product in the cart after discount: " + cart1.getTotalPrice());

    }
    public static void testInventory(){
        Product p = new Product("Dien thoai", 260, "Thiet bi dien tu");
        Product p1 = new Product("Dien thoai", 2500, "Thiet bi dien tu");
        Product p2 = new Product("Laptop", 500, "Thiet bi dien tu");

        Product p3 = new Product("Laptop");



        HashMap<Product, Integer> hashMap = new HashMap<>();
        hashMap.put(p, 10);
        hashMap.put(p1, 20);

        Inventory inv = new Inventory(hashMap);

        System.out.println("Product has the stock: " + inv.checkStock(p));

        inv.restock(p2, 100);


        HashMap<Product, Integer> orderProduct = new HashMap<>();

        orderProduct.put(p, 4);
        orderProduct.put(p2, 5);

        User user = new User("bao", "bao@");

        Order order = new Order(1, user, orderProduct);



        order.setOrderStatus(Order.OrderStatus.PROCESSING);
        inv.detectStock(order);

        System.out.println("So luong p con lai: " + inv.checkStock(p));

    }

    public static void testCustomerAndAdmin(){
        Admin admin = new Admin("admin01", "admin@mail.com", "admin123");

        Customer customer = new Customer("customer01", "customer@mail.com", "cust123");

        Product phone = new Product("Dien thoai", 1000, "thiet bi dien tu", 50);
        Product laptop = new Product("Lap top", 2000, "thiet bi dien tu", 30);

        admin.showPermissions();
        customer.showPermissions();

        admin.addProduct(phone);
        admin.addProduct(laptop);

        customer.addProductToYourCart(phone, 1);

        customer.writeReview(phone, 5, "Great phone!");
        customer.getProductsInProductManager();



    }

}
