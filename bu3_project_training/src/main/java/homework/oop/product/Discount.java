package homework.oop.product;

import homework.oop.order.Cart;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;


@Getter
@Setter
public class Discount {
    private Product product;

    public Discount() {
    }
    public void applyDiscount(Product product, double percentage) {
        if (percentage < 1 || percentage > 100) {
            throw new IllegalArgumentException("percentage must be between 1 and 100");
        }
        double discount = product.getPrice() * percentage / 100;
        product.setPrice(product.getPrice() - discount);
    }
    public void applyBulkDiscount(Cart cart, double minThresholdPercentage, double discountPercentage) {
        double priceTotal = cart.getTotalPrice();

        if (priceTotal > minThresholdPercentage) {
//            cart.getItems().forEach(items -> applyDiscount(product, discountPercentage));
            for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()){
                Product product = entry.getKey();
                double percentage = entry.getValue();
                applyDiscount(product, percentage);
            }
        }
    }
}
