package _11_FunctionalProgramming_Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


//        IntStream stream = null; // IntStream[int, int, int, int]
//        Stream<Integer> stream1 = null // [Integer, Integer, Integer, ]
//         .map(Integer::parseInt) връща Integer
//         .mapToInt(Integer::parseInt) връща int

        Function<int[], String> count = elements -> "Count = " +
                Arrays.stream(elements).count();
        Function<int[], String> sum = elements -> "Sum = " +
                Arrays.stream(elements).sum();

        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(count.apply(numbers));
        System.out.println(sum.apply(numbers));


    }
}
