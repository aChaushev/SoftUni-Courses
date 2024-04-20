package ExamPreparations._20_JavaAdvancedRetakeExam_12April2023;

import java.util.Scanner;

public class _02_TheSquirrel {

    public static int squirrelRow;
    public static int squirrelCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] commandsData = scanner.nextLine().split(",\\s+");

        String[][] matrix = new String[size][size];

        for (int row = 0; row < size; row++) {
            String matrixRow = scanner.nextLine();
            matrix[row] = matrixRow.split("");

            if (matrixRow.contains("s")) {
                squirrelRow = row;
                squirrelCol = matrixRow.indexOf("s");
            }
        }

        int hazelnuts = 0;
        boolean lessHazelnutsPrint = true;

        for (String command : commandsData) {
            matrix[squirrelRow][squirrelCol] = "*";

            int nextRow = squirrelRow;
            int nextCol = squirrelCol;

            if (command.equals("up") && nextRow > 0) {
                nextRow--;
            } else if (command.equals("down") && nextRow < matrix.length - 1) {
                nextRow++;
            } else if (command.equals("left") && nextCol > 0) {
                nextCol--;
            } else if (command.equals("right") && nextCol < matrix[nextRow].length - 1) {
                nextCol++;
            } else {
                System.out.println("The squirrel is out of the field.");
                lessHazelnutsPrint = false;
                break;
            }

            if (matrix[nextRow][nextCol].equals("t")) {
                System.out.println("Unfortunately, the squirrel stepped on a trap...");
                lessHazelnutsPrint = false;
                break;
            } else if (matrix[nextRow][nextCol].equals("h")) {
                hazelnuts++;
            }

            squirrelRow = nextRow;
            squirrelCol = nextCol;

            matrix[squirrelRow][squirrelCol] = "s";

            if (hazelnuts == 3) {
                System.out.println("Good job! You have collected all hazelnuts!");
                lessHazelnutsPrint = false;
                break;
            }
//            System.out.println("-----------------------");
//            printMatrix(matrix);
//            System.out.println("-----------------------");
        }

        if (lessHazelnutsPrint) {
            System.out.println("There are more hazelnuts to collect.");
        }
        System.out.printf("Hazelnuts collected: %d\n", hazelnuts);


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
