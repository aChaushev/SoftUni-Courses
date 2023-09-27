package _06_MultidimensionalArrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _04_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int maxSum = Integer.MIN_VALUE;
        int bestStartingRow = 0;
        int bestStartingCol = 0;
        for (int r = 0; r < rows - 2; r++) {
            for (int c = 0; c < cols - 2; c++) {
//                int currentSum = matrix[r][c] + matrix[r][c + 1] + matrix[r][c + 2] +
//                        matrix[r + 1][c] + matrix[r + 1][c + 1] + matrix[r + 1][c + 2]+
//                        matrix[r + 2][c] + matrix[r + 2][c + 1] + matrix[r + 2][c + 2];

                int currentSum = 0;
                for (int i = r; i < r + 3; i++) {
                    for (int j = c; j < c + 3; j++) {
                        currentSum += matrix[i][j];
                    }
                }

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    bestStartingRow = r;
                    bestStartingCol = c;
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        for (int r = bestStartingRow; r < bestStartingRow + 3; r++) {
            for (int c = bestStartingCol; c < bestStartingCol + 3; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
