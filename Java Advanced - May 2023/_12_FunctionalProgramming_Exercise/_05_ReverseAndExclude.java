package _12_FunctionalProgramming_Exercise;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int dividableNum = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);

        Predicate<Integer> checkDivisibleByN = e -> e % dividableNum == 0;
        numbers.removeIf(checkDivisibleByN);

        Consumer<Integer> printNumber = number -> System.out.print(number + " ");
        numbers.forEach(printNumber);

    }
}
