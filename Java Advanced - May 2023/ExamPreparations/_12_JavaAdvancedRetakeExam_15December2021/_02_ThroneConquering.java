package ExamPreparations._12_JavaAdvancedRetakeExam_15December2021;

import java.util.*;

public class _02_ThroneConquering {

    public static int parisRow;
    public static int parisCol;

    public static int helenRow;
    public static int helenCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int matrixSize = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            String matrixRow = scanner.nextLine();
            matrix[row] = matrixRow.split("");

            if (matrixRow.contains("P")) {
                parisRow = row;
                parisCol = matrixRow.indexOf("P");

            }
            if (matrixRow.contains("H")) {
                helenRow = row;
                helenCol = matrixRow.indexOf("H");

            }
        } // END FOR


        boolean isAbducted = false;
        while (energy > 0) {
            String[] moveData = scanner.nextLine().split("\\s+");
            String command = moveData[0];
            int enemyRow = Integer.parseInt(moveData[1]);
            int enemyCol = Integer.parseInt(moveData[2]);
            matrix[enemyRow][enemyCol] = "S";
            energy--;
            matrix[parisRow][parisCol] = "-";
            if (command.equals("up") && parisRow > 0) {
                parisRow--;
            } else if (command.equals("down") && parisRow < matrix.length - 1) {
                parisRow++;
            } else if (command.equals("left") && parisCol > 0) {
                parisCol--;
            } else if (command.equals("right") && parisCol < matrix[parisRow].length - 1) {
                parisCol++;
            }

            String parisCurrentPosition = matrix[parisRow][parisCol];
            if (parisCurrentPosition.equals("S")) {
                energy -= 2;
            } else if (parisCurrentPosition.equals("H")) {
                matrix[parisRow][parisCol] = "-";
                matrix[helenRow][helenCol] = "-";
                isAbducted = true;
                break;
            }
            matrix[parisRow][parisCol] = "P";

//            System.out.println("******************");
//            printMatrix(matrix);
//            System.out.println("******************");

        } //END WHILE

        // PRINT
        if (isAbducted) {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d\n", energy);
            printMatrix(matrix);
        } else {
            matrix[parisRow][parisCol] = "X";
            System.out.printf("Paris died at %d;%d.\n", parisRow, parisCol);
            printMatrix(matrix);

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
