package homework.oop.product;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Electronics extends Product{
    private String brand;
    private String wrranty;

    public Electronics(String name, double price, String category, int stock, String brand, String wrranty) {
        super(name, price, category, stock);
        this.brand = brand;
        this.wrranty = wrranty;
    }

    @Override
    public void showProduct() {
        super.showProduct();
        System.out.println("Brand: " + brand);
        System.out.println("Wrranty: " + wrranty);
    }
}
