package _06_MultidimensionalArrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] commandArr = command.split("\\s+");
            if (commandArr[0].equals("swap") && commandArr.length == 5
                    && isRowValidCoordinate(rows, commandArr[1]) && isColValidCoordinate(cols, commandArr[2])
                    && isRowValidCoordinate(rows, commandArr[3]) && isColValidCoordinate(cols, commandArr[4])) {
                int row1 = Integer.parseInt(commandArr[1]);
                int col1 = Integer.parseInt(commandArr[2]);
                int row2 = Integer.parseInt(commandArr[3]);
                int col2 = Integer.parseInt(commandArr[4]);
                String firstElementToSwap = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = firstElementToSwap;
                printMatrix(matrix);

            } else {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine();
        }

    }

    private static boolean isRowValidCoordinate(int rows, String input) {
        int index = Integer.parseInt(input);
        return index >= 0 && index < rows;
    }

    private static boolean isColValidCoordinate(int cols, String input) {
        int index = Integer.parseInt(input);
        return index >= 0 && index < cols;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String s : arr) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
