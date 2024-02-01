package _12_FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;


public class _06_PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nameLength = Integer.parseInt(scanner.nextLine());
        String[] namesList = scanner.nextLine().split("\\s+");

        Predicate<String> checkLength = name -> name.length() <= nameLength;

        Arrays.stream(namesList)
                .filter(checkLength)
                .forEach(System.out::println);
        // обхождат се елементите
        //true -> оствя елемента

    }
}
