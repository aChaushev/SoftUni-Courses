package _05_MultidimensionalArrays_Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _08_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = getToArray(scanner);
        }

        int[] indexes = getToArray(scanner);

        int valueToReplace = matrix[indexes[0]][indexes[1]];

        List<int[]> correctValuesList = new ArrayList<>();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == valueToReplace) {
                    int correctValue = getCorrectValue(matrix, r, c, valueToReplace);
                    correctValuesList.add(new int[]{r, c, correctValue});
                }
            }
        }

        for (int[] correctValue : correctValuesList) {
            int row = correctValue[0];
            int col = correctValue[1];
            matrix[row][col] = correctValue[2];
        }

        for (int[] arr : matrix) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

    }

    private static int getCorrectValue(int[][] matrix, int r, int c, int valueToReplace) {

        int sum = 0;

        if (isInBounds(matrix, r + 1, c) && matrix[r + 1][c] != valueToReplace) {
            sum += matrix[r + 1][c];
        }
        if (isInBounds(matrix, r - 1, c) && matrix[r - 1][c] != valueToReplace) {
            sum += matrix[r - 1][c];
        }
        if (isInBounds(matrix, r, c + 1) && matrix[r][c + 1] != valueToReplace) {
            sum += matrix[r][c + 1];
        }
        if (isInBounds(matrix, r, c - 1) && matrix[r][c - 1] != valueToReplace) {
            sum += matrix[r][c - 1];
        }

        return sum;
    }

    private static boolean isInBounds(int[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static int[] getToArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
