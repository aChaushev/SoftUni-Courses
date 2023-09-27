package _05_MultidimensionalArrays_Lab;

import java.util.Scanner;

public class _03_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] firstMatrix = new String[rows][cols];
        String[][] secondMatrix = new String[rows][cols];
        String[][] resultMatrix = new String[rows][cols];


        writeStringMatrix(scanner, firstMatrix);
        writeStringMatrix(scanner, secondMatrix);

        for (int r = 0; r < resultMatrix.length; r++) {
            for (int c = 0; c < resultMatrix[r].length; c++) {
                if (firstMatrix[r][c].equals(secondMatrix[r][c])) {
                    resultMatrix[r][c] = firstMatrix[r][c];
                } else {
                    resultMatrix[r][c] = "*";
                }
            }
        }

        for (String[] arr : resultMatrix) {
            for (String s : arr) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

    }

    private static void writeStringMatrix(Scanner scanner, String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }
    }
}

