package _12_FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class _02_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] namesArr = scanner.nextLine().split("\\s+");

        Consumer<String[]> printNames =
                array -> Arrays.stream(array)
                        .forEach(name -> System.out.println("Sir " + name));

        printNames.accept(namesArr);

    }
}
