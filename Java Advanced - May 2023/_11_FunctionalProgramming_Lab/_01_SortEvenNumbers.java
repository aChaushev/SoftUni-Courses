package _11_FunctionalProgramming_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(numbers.stream()  // орпечатай резултата от стрийма
                .map(String::valueOf)        // от числа правя стрингове
                .collect(Collectors.joining(", ")));// връщаш го като един стринг долепени със ", "

//        Collections.sort(numbers); // сортира елементите от листа и ги запазва в листа

        System.out.println(numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));

//
//        numbers.stream().
//                sorted()  // сортира потока
//                .forEach(System.out::println); // принтира потока

    }
}
