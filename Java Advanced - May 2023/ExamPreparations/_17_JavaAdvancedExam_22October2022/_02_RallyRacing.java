package ExamPreparations._17_JavaAdvancedExam_22October2022;

import java.util.Scanner;

public class _02_RallyRacing {
    public static int carRow = 0;
    public static int carCol = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String racingNumber = scanner.nextLine();

        String[][] matrix = new String[size][size];

        for (int row = 0; row < size; row++) {
            String matrixRow = scanner.nextLine();
            matrix[row] = matrixRow.split("\\s+");
        }
        int distance = 0;
        boolean hasWon = false;
        matrix[carRow][carCol] = "C";
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            matrix[carRow][carCol] = ".";
            if (command.equals("up")) {
                carRow--;
            } else if (command.equals("down")) {
                carRow++;
            } else if (command.equals("left")) {
                carCol--;
            } else if (command.equals("right")) {
                carCol++;
            }

            String carPosition = matrix[carRow][carCol];
            if (carPosition.equals(".")) {
                distance += 10;
            } else if (carPosition.equals("T")) {
                matrix[carRow][carCol] = ".";
                findTunnelExit(matrix);
                distance += 30;
            } else if (carPosition.equals("F")) {
                matrix[carRow][carCol] = "C";
                distance += 10;
                hasWon = true;
                break;
            }
            matrix[carRow][carCol] = "C";

            command = scanner.nextLine();

        }
        if (hasWon) {
            System.out.printf("Racing car %s finished the stage!\n", racingNumber);
        } else {
            System.out.printf("Racing car %s DNF.\n", racingNumber);
        }
        System.out.printf("Distance covered %d km.\n", distance);
        printMatrix(matrix);

    }

    private static void findTunnelExit(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("T")) {
                    matrix[row][col] = "C";
                    carRow = row;
                    carCol = col;
                    break;
                }
            }
        }
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
