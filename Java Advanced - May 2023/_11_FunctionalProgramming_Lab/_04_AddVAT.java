package _11_FunctionalProgramming_Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.Collectors;

public class _04_AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] prices = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        DoubleUnaryOperator addVat = p -> p * 1.20;

        Consumer<double[]> printPrices = p -> {
            System.out.println("Prices with VAT:");
            System.out.println(Arrays.stream(p)
                    .map(addVat)
                    .mapToObj(d -> String.format("%.2f", d))
                    .collect(Collectors.joining(System.lineSeparator())));
        };

        printPrices.accept(prices);

    }
}
