package _08_SetsAndMapsAdvanced_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> elementsSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] elementsArr = scanner.nextLine().split("\\s+");
            elementsSet.addAll(Arrays.asList(elementsArr));
        }

        elementsSet.forEach(e -> System.out.print(e + " "));

    }
}
