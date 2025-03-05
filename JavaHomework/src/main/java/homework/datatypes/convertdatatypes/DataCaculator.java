package homework.datatypes.convertdatatypes;

import java.util.List;
import java.util.stream.Collectors;

public class DataCaculator {

    public void convertInchToMeter(short inch) {
        double meters = inch * 0.0254; // 1 inch = 0.0254 meters
        System.out.printf("%d inch = %.4f meters%n", inch, meters);
    }

    public void convertMinutesToDate (int minutes) {
        int days = minutes / (60 * 24);
        int years = days / 365;
        int remainingDays = days % 365;

        System.out.printf("%d minutes = %d years and %d days%n", minutes, years, remainingDays);
    }

    public List<Integer> sortStringIntegerNumber(long number) {
        return String.valueOf(number)
                .chars()
                .mapToObj(c -> Character.getNumericValue(c))
                .sorted()
                .collect(Collectors.toList());


//        List<Character> list = new ArrayList<Character>();
//
//        String stringNumber = String.valueOf(number);
//
//        for (int i = 0; i < stringNumber.length(); i++) {
//            char ch = stringNumber.charAt(i);
//            list.add(ch);
//        }
//
//        list.sort(new Comparator<Character>() {
//            @Override
//            public int compare(Character o1, Character o2) {
//                return o1.compareTo(o2);
//            }
//        });
//
//        System.out.println(list.toString());
    }

    public void caculatorSpeed (int distance, int hours, int minutes, int seconds) {
        int totalSeconds = hours * 3600 + minutes * 60 + seconds;

        //Tốc độ tính theo m/s
        float speedMetersPerSecond = (float) distance / totalSeconds;
        System.out.printf("Speed: %.6f m/s%n", speedMetersPerSecond);


        float timeHours = hours + minutes/60.f + seconds/3600.f;  //Đổi từ giây sang giờ
        float distanceKilometers = distance / 1000.0f; //Đổi sang km
        float speedKilometersPerHour = distanceKilometers / timeHours;

        System.out.printf("Speed: %.6f km/h%n", speedKilometersPerHour);
    }



}
