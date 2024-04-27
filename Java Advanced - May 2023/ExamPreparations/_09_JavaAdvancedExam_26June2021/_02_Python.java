package ExamPreparations._09_JavaAdvancedExam_26June2021;

import java.util.Scanner;

public class _02_Python {

    public static int pythonRow;
    public static int pythonCol;
    public static int pythonLength = 1;
    public static int foodToBeEaten;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        String[] commandsInput = scanner.nextLine().split(",\\s+");

        String[][] matrix = new String[matrixSize][matrixSize];

        fillMatrix(scanner, matrix);

        foodOnTheField(matrix);

        for (String command : commandsInput) {

            matrix[pythonRow][pythonCol] = "*";

            if (command.equals("up")) {
                pythonRow--;
            } else if (command.equals("down")) {
                pythonRow++;
            } else if (command.equals("left")) {
                pythonCol--;
            } else if (command.equals("right")) {
                pythonCol++;
            }

            moveOutsideMatrixChecker(matrix);

            String currentPosition = matrix[pythonRow][pythonCol];
            if (currentPosition.equals("f")) {
                pythonLength++;
                foodToBeEaten--;
                matrix[pythonRow][pythonCol] = "*";
                if (foodToBeEaten == 0) {
                    System.out.printf("You win! Final python length is %d\n", pythonLength);
                    return;
                }
            } else if (currentPosition.equals("e")) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
            matrix[pythonRow][pythonCol] = "s";

//            System.out.println("--------------------------");
//            printMatrix(matrix);
//            System.out.println("--------------------------");

        }

        System.out.printf("You lose! There is still %d food to be eaten.\n", foodToBeEaten);


    }

    private static void moveOutsideMatrixChecker(String[][] matrix) {
        if (isOutOfBounds(matrix, pythonRow, pythonCol)) {
            if (pythonRow < 0) {
                pythonRow = matrix.length - 1;
            } else if (pythonRow > matrix.length - 1) {
                pythonRow = 0;
            } else if (pythonCol < 0) {
                pythonCol = matrix[pythonRow].length - 1;
            } else if (pythonCol > matrix[pythonRow].length - 1) {
                pythonCol = 0;
            }
        }
    }

    private static boolean isOutOfBounds(String[][] matrix, int r, int c) {
        return r < 0 || r > matrix.length - 1 || c < 0 || c > matrix[r].length - 1;
    }

    private static void foodOnTheField(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                if (string.equals("f")) {
                    foodToBeEaten++;
                }
            }
        }
    }

    private static void fillMatrix(Scanner scanner, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String matrixRow = scanner.nextLine();
            matrix[row] = matrixRow.split("\\s+");

            if (matrixRow.contains("s")) {
                String currentRowArr = matrixRow.replace(" ", "");
                pythonRow = row;
                pythonCol = currentRowArr.indexOf("s");

            }
        }
    }

//    private static void printMatrix(String[][] matrix) {
//        for (String[] element : matrix) {
//            for (String e : element) {
//                System.out.print(e);
//            }
//            System.out.println();
//        }
//    }
}
