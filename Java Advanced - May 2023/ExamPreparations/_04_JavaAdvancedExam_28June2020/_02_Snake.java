package ExamPreparations._04_JavaAdvancedExam_28June2020;

import java.util.Scanner;

public class _02_Snake {

    public static int playersRow;
    public static int playersCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            String matrixRow = scanner.nextLine();
            matrix[row] = matrixRow.split("");

            if (matrixRow.contains("S")) {
                playersRow = row;
                playersCol = matrixRow.indexOf("S");
            }
        }

        int foodEaten = 0;

        while (foodEaten < 10) {
            String command = scanner.nextLine();

            matrix[playersRow][playersCol] = ".";

            if (command.equals("up") && playersRow > 0) {
                playersRow--;
            } else if (command.equals("down") && playersRow < matrix.length - 1) {
                playersRow++;
            } else if (command.equals("left") && playersCol > 0) {
                playersCol--;
            } else if (command.equals("right") && playersCol < matrix[playersRow].length - 1) {
                playersCol++;
            } else {
                System.out.println("Game over!");
                break;
            }

            String currentPosition = matrix[playersRow][playersCol];
            if (currentPosition.equals("*")) {
                foodEaten++;

            } else if (currentPosition.equals("B")) {
                matrix[playersRow][playersCol] = ".";
                findBurrowExit(matrix);
            }

            matrix[playersRow][playersCol] = "S";
        }

        if (foodEaten >= 10) {
            System.out.println("You won! You fed the snake.");
        }

        System.out.printf("Food eaten: %d%n", foodEaten);

        printMatrix(matrix);

    }

    private static void findBurrowExit(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("B")) {
                    playersRow = row;
                    playersCol = col;
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
