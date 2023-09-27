package _12_Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class E08_MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int targetSum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numbersArr.length; i++) {
            for (int j = i + 1; j < numbersArr.length; j++) {
                if (numbersArr[i] + numbersArr[j] == targetSum) {
                    System.out.println(numbersArr[i] + " " + numbersArr[j]);
                }
            }
        }
    }
}
