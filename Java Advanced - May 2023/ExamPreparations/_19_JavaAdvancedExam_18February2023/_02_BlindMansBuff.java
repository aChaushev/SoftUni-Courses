package ExamPreparations._19_JavaAdvancedExam_18February2023;

import java.util.Scanner;

public class _02_BlindMansBuff {

    public static int playersRow;
    public static int playersCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixDimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(matrixDimensions[0]);
        int cols = Integer.parseInt(matrixDimensions[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            if (!scanner.hasNext()) {
                return;
            }
            String matrixRow = scanner.nextLine();
            matrix[row] = matrixRow.split("\\s+");

            if (matrix[row].length != cols) {
                return;
            }

            if (matrixRow.contains("B")) {
                String currentRowArr = matrixRow.replace(" ", "");
                playersRow = row;
                playersCol = currentRowArr.indexOf("B");

            }
        }

        String command = scanner.nextLine();
        int movesMade = 0;
        int touchedOpponents = 0;


        while (!"Finish".equals(command)) {

            matrix[playersRow][playersCol] = "-";

            int nextRow = playersRow;
            int nextCol = playersCol;

            if (command.equals("up") && nextRow > 0) {
                nextRow--;
            } else if (command.equals("down") && nextRow < matrix.length - 1) {
                nextRow++;
            } else if (command.equals("left") && nextCol > 0) {
                nextCol--;
            } else if (command.equals("right") && nextCol < matrix[nextRow].length - 1) {
                nextCol++;
            } else { //когато сме извън матрицата
                command = scanner.nextLine();
                continue;
            }

            if (matrix[nextRow][nextCol].equals("O")) {
                command = scanner.nextLine();
                continue;
            }

            movesMade++;

            if (matrix[nextRow][nextCol].equals("P")) {
                touchedOpponents++;
            }
            matrix[nextRow][nextCol] = "B";
            playersRow = nextRow;
            playersCol = nextCol;

            if (touchedOpponents == 3) {
                break;
            }

            command = scanner.nextLine();

//            System.out.println("-----------------");
//            printMatrix(matrix);
//            System.out.println("-----------------");
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d\n", touchedOpponents, movesMade);

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
