package homework.oop.payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCardPayment extends Payment{

    private String cardNumber;
    private String cardUserName;
    private String cardExpiryDate;
    private double creditBalance;

    public CreditCardPayment(String cardNumber, String cardUserName, String cardExpiryDate, double creditBalance) {
        this.cardNumber = cardNumber;
        this.cardUserName = cardUserName;
        this.cardExpiryDate = cardExpiryDate;
        this.creditBalance = creditBalance;
    }


    public void processPayment(double amount) {
        if (amount > creditBalance) {
            throw new IllegalArgumentException("Balance is not enough to pay.");
        }
        creditBalance -= amount;
        System.out.println("Credit Card Payment successful. The remaining balance: " + creditBalance);

    }

}
