package homework.collection.payment;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaypalPayment extends Payment {

    private String paypalEmail;
    private double paypalBalance;

    public PaypalPayment(String paypalEmail, double paypalBalance) {
        this.paypalEmail = paypalEmail;
        this.paypalBalance = paypalBalance;
    }

    public void processPayment(double amount) {
        if (amount > paypalBalance) {
            throw new IllegalArgumentException("The payment amount exceeds the Paypal balance ");
        }
        paypalBalance -= amount;
        System.out.println("Successfully paid " + amount + " paypal payment");
    }

}
