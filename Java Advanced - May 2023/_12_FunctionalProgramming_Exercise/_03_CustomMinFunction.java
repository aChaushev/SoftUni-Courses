package _12_FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

//      решение I
//        System.out.println(Collections.min(numbers));

//      решение II
//        Consumer<List<Integer>> printMinNumber =
//                list -> System.out.println(Collections.min(numbers));
//
//        printMinNumber.accept(numbers);

//      решение III
        Function<List<Integer>, Integer> getMinNumber = list -> Collections.min(numbers);

        System.out.println(getMinNumber.apply(numbers));


    }
}
