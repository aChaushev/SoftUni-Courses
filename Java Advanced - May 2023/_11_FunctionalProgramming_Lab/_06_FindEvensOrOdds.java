package _11_FunctionalProgramming_Lab;

import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _06_FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");

        int begin = Integer.parseInt(data[0]);
        int end = Integer.parseInt(data[1]);

        String filter = scanner.nextLine();

        IntPredicate predicate = n ->
                filter.equals("even")  // ako filter e even
                        ? n % 2 == 0   // изпълни тово
                        : n % 2 != 0;  // ако не е -> изпълни това

        String output = IntStream.rangeClosed(begin, end) // пусни stream в този range
                .filter(predicate) // филтрирай по predicate
                .mapToObj(String::valueOf)  // превърни в String
                .collect(Collectors.joining(" ")); // запази със следния разделител

        System.out.println(output);
    }
}
