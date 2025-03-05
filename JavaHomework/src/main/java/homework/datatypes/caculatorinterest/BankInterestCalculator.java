package homework.datatypes.caculatorinterest;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
public class BankInterestCalculator {
    private BigDecimal principal;
    private BigDecimal interestRate;

    public BankInterestCalculator(double principal, double interestRate) {
        this.principal = BigDecimal.valueOf(principal);
        this.interestRate = BigDecimal.valueOf(interestRate);
    }

    public BigDecimal calculateInterest(int yearNumber) {
        BigDecimal totalAmount = principal.multiply(BigDecimal.ONE.add(interestRate).pow(yearNumber));
        return totalAmount.subtract(principal).setScale(2, RoundingMode.HALF_UP);
    }

    public void printInterest(int yearNumber) {
        System.out.printf("The interest you receive after %d years of deposit is: %s%n"
                ,yearNumber, calculateInterest(yearNumber));
    }
}
