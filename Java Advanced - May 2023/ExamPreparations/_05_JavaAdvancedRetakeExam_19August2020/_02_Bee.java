package ExamPreparations._05_JavaAdvancedRetakeExam_19August2020;

import java.util.Scanner;

public class _02_Bee {

    public static int beeRow;
    public static int beeCol;
    public static int pollinatedFlowers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            String matrixRow = scanner.nextLine();
            matrix[row] = matrixRow.split("");

            if (matrixRow.contains("B")) {
                beeRow = row;
                beeCol = matrixRow.indexOf("B");

            }
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            // before move ->
            matrix[beeRow][beeCol] = ".";
            if (command.equals("up")) {
                beeRow--;
            } else if (command.equals("down")) {
                beeRow++;
            } else if (command.equals("left")) {
                beeCol--;
            } else if (command.equals("right")) {
                beeCol++;
            }

            if (isOutOfBounds(matrix, beeRow, beeCol)) {
                System.out.println("The bee got lost!");
                break;
            }
            String beeCurrentPosition = matrix[beeRow][beeCol];
            if (beeCurrentPosition.equals("f")) {
                pollinatedFlowers++;

            } else if (beeCurrentPosition.equals("O")) {
                continue;
            }

            // after move ->
            matrix[beeRow][beeCol] = "B";

            command = scanner.nextLine();
        }

        if (pollinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", 5 - pollinatedFlowers);
        }

        printMatrix(matrix);


    }
    private static boolean isOutOfBounds(String[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] element : matrix) {
            for (String e : element) {
                System.out.print(e);
            }
            System.out.println();
        }
    }
}
