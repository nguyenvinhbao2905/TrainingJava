package homework.featurejava;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple", "banana", "kiwi", "pear", "grape", "mango");
        List<Integer> numbers = Arrays.asList(10, 5, 8, 1, 3, 7, 2, 6, 4, 9, 10, 2);


        System.out.println("Testing groupStringByLength:");
        groupStringByLength(words);
        System.out.println();

        System.out.println("Testing convertString:");
        convertString();
        System.out.println();

        System.out.println("Testing caculatorSumNumber:");
        caculatorSumNumber(numbers);
        System.out.println();

        System.out.println("Testing sortStrings:");
        sortStrings(new ArrayList<>(words)); // Copy lại dữ liệu, ko thay đổi dữ liệu gốc
        System.out.println();

        System.out.println("Testing findNumber:");
        findNumber(numbers);
        System.out.println();

        System.out.println("Testing joiningStrings:");
        joiningStrings(words);
        System.out.println();

        System.out.println("Testing convertToMap:");
        convertToMap();
        System.out.println();

        System.out.println("Testing findFirstEvenNumber:");
        findFirstEvenNumber(numbers);
        System.out.println();

        scanner.close();
    }

    public static void convertString() {
        System.out.println("Input string: ");
        String currentString = scanner.nextLine();

        String result = currentString.chars().mapToObj(c -> (char) c)
                .map(String::valueOf)
                .collect(Collectors.joining())
                .toLowerCase();
        System.out.println("String converted to lowercase: " + result);
    }

    public static void caculatorSumNumber(List<Integer> numbers) {
        int totalOddNumber = numbers.stream().filter(number -> number % 2 == 0).mapToInt(number -> number).sum();
        System.out.println("Sum of odd numbers in list: " + totalOddNumber);

        int totalEvenNumber = numbers.stream().filter(number -> number % 2 != 0).mapToInt(number -> number).sum();
        System.out.println("Sum of even numbers in list: " + totalEvenNumber);
    }
    public static void sortStrings(List<String> strings) {
        List<String> sortedAsc =  strings.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted strings increase : " + sortedAsc);
        List<String> sortedDesc =  strings.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("Sorted strings decrease : " + sortedDesc);

    }
    public static void findNumber(List<Integer> numbers) {
        int secondMinimumNumber = numbers.stream().distinct().sorted().skip(1).findFirst().get();
        System.out.println("Second minimum number is: " + secondMinimumNumber);

        int maximumNumber = numbers.stream().distinct().max(Integer::compareTo).get();
        System.out.println("Maximum number: " + maximumNumber);
    }

    public static void groupStringByLength(List<String> strings) {
        Map<Integer, List<String>> groupByLength = strings.stream().collect(Collectors.groupingBy(String::length));

        groupByLength.forEach((length, words) -> System.out.println("Length (" + length + ") : " + String.join(", ", words)));
    }

    public static void joiningStrings(List<String> strings) {
        System.out.println("String list after joining: ");
        String result = strings.stream().collect(Collectors.joining(", "));
        System.out.println(result);
    }

    public static void convertToMap () {
        List<Person> people = Arrays.asList(new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 30),
                new Person("Charlie", 30),
                new Person("Charlie", 30),
                new Person("David", 25),
                new Person("Emma", 35),
                new Person("Alice", 28),
                new Person("Bob", 27));

        Map<String, List<Person>> uniqueByName = people.stream()
                        .collect(Collectors.toMap(Person::getName, p -> new ArrayList<>(List.of(p)),
                                (existing, replacement) -> {
                                    existing.addAll(replacement);
                                    return existing;
                                 }
                                ));
        uniqueByName.forEach((name, persons) ->
            System.out.println("Name: " + name + " - Person: " + persons));
    }

    public static void findFirstEvenNumber(List<Integer> numbers) {
        Optional<Integer> firstEvenNumber = numbers.stream().filter(number -> number % 2 == 0).findFirst();
        firstEvenNumber.ifPresentOrElse(
                number -> System.out.println("First even number: " + number),
                () -> System.out.println("No even number found!!!")
        );

    }
}
