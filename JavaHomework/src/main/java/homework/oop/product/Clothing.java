package homework.oop.product;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Clothing extends Product{
    private int size;
    private String material;

    public Clothing(String name, double price, String category, int stock, int size, String material) {
        super(name, price, category, stock);
        this.size = size;
        this.material = material;
    }

    public void showProduct() {
        super.showProduct();
        System.out.println("Size: " + size);
        System.out.println("Material: " + material);
    }
}
