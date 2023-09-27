package _06_MultidimensionalArrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Intro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = 2;
        int cols = 3;

        int[][] matrix = new int[rows][cols];

        // read with 2 for loop
        for (int r = 0; r < rows; r++) {
            String[] rowFromConsole = scanner.nextLine().split("\\s+");
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = Integer.parseInt(rowFromConsole[c]);
            }
        }

        // read with 2 for loop
        for (int r = 0; r < rows; r++) {
            int[] rowFromConsole = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = rowFromConsole[c];
            }
        }

        // read with 1 for loop and Stream API
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        //print with for loop
        for (int r = 0; r < rows; r++) { // rows loop
            for (int c = 0; c < cols; c++) { // columns loop
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }

        //print with forEach
        for (int[] arr : matrix) { // rows loop
            for (int n : arr) { // columns loop
                System.out.print(n + " ");
            }
            System.out.println();
        }

    }
    private static boolean areValidCoordinates(String[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;

    }
}
