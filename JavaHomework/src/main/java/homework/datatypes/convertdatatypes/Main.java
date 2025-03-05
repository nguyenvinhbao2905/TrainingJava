package homework.datatypes.convertdatatypes;

public class Main {
    public static void main(String[] args) {
        DataCaculator c = new DataCaculator();

        c.convertInchToMeter((short) 3);
        c.convertMinutesToDate(3456789);
        System.out.println(c.sortStringIntegerNumber(84456312));
        c.caculatorSpeed(2500,  5,  56,  23);
    }
}
