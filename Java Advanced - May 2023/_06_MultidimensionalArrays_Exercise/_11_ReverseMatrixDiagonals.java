package _06_MultidimensionalArrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _11_ReverseMatrixDiagonals {
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

        int row = rows - 1;
        int col = cols - 1;

        while (row >= 0){
            int r = row;
            int c = col;
            while (c < cols && r >= 0){
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            col--;
            if(col < 0){
                col = 0;
                row--;
            }

        }

    }
}
