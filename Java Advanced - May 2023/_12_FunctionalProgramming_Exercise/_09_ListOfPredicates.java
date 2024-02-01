package _12_FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class _09_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        // отпечатай всички числа от 1 до n, ако се дели на всички числа от списъка
        // isDivisible въща true/false
        BiFunction<Integer, List<Integer>, Boolean> isDivisible = (number, list) -> {
            for (int listNum : list) {
                if (number % listNum != 0) {
                    return false;
                }
            }
            return true;
        };

        // проверяваме всяко число от 1 до n дали се дели на всички числа от списъка
        for (int num = 1; num <= n; num++) {
            if (isDivisible.apply(num, numbers)) {
                System.out.print(num + " ");
            }
        }

    }
}
