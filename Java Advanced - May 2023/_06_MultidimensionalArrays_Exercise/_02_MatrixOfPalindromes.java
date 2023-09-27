package _06_MultidimensionalArrays_Exercise;

import java.util.Scanner;

public class _02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);


        String[][] matrix = new String[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char outsideLetter = (char) ('a' + r);
                char insideLetter = (char) ('a' + r + c);
                matrix[r][c] = String.valueOf(outsideLetter) + insideLetter + outsideLetter;

            }
        }

        for (String[] arr : matrix) {
            for (String s : arr) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
