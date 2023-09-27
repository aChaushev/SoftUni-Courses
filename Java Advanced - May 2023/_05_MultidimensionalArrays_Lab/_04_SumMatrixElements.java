package _05_MultidimensionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _04_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        int[][] matrix = new int[rows][cols];

        int sum = 0;
        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            for (int c = 0; c < cols; c++) {
                sum += matrix[r][c];
            }

        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
