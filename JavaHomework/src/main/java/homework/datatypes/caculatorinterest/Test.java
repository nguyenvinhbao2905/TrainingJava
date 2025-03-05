package homework.datatypes.caculatorinterest;

public class Test {
    public static void main(String[] args) {
        BankInterestCalculator calculator = new BankInterestCalculator(1000, 0.05);
        calculator.printInterest(1);

        calculator.printInterest(2);
    }
}
