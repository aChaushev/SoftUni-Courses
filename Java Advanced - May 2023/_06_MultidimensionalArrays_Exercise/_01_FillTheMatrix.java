package _06_MultidimensionalArrays_Exercise;

import java.util.Scanner;

public class _01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[size][size];

        int counter = 1;

        if (pattern.equals("A")) {
            for (int col = 0; col < size; col++) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }

            printMatrix(matrix);

        } else if (pattern.equals("B")) {
            for (int col = 0; col < size; col++) {
                if (col % 2 == 0) {
                    for (int row = 0; row < size; row++) {
                        matrix[row][col] = counter;
                        counter++;
                    }
                } else {
                    for (int row = size - 1; row >= 0; row--) {
                        matrix[row][col] = counter;
                        counter++;
                    }
                }
            }

            printMatrix(matrix);
        }

    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
