package _06_MultidimensionalArrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int primarySum = 0;
        for (int i = 0; i < matrix.length; i++) {
            primarySum += matrix[i][i];
        }

        int secondSum = 0;
        for (int row = matrix.length - 1, col = 0; row >= 0 && col < matrix.length; row--, col++) {
            secondSum += matrix[row][col];
        }

        System.out.println(Math.abs(primarySum - secondSum));

    }
}
