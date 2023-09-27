package _07_SetsAndMapsAdvanced_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _09_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());

        for (int i = 0; i < 3; i++) {
            if (numbersList.size() - 1 < i) {
                break;
            }
            System.out.print(numbersList.get(i) + " ");
        }
    }
}
