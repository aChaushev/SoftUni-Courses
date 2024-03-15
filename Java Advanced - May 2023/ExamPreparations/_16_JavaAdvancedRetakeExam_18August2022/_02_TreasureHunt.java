package ExamPreparations._16_JavaAdvancedRetakeExam_18August2022;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class _02_TreasureHunt {

    public static int playersRow;

    public static int playersCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String matrixRow = scanner.nextLine();
            matrix[row] = matrixRow.split("\\s+");

            if (matrixRow.contains("Y")) {
                String currentRowArr = matrixRow.replace(" ", "");
                playersRow = row;
                playersCol = currentRowArr.indexOf("Y");

            }
        }

        boolean hasFoundTreasure = false;
        StringBuilder treasurePath = new StringBuilder();

        String command = scanner.nextLine();

        while (!command.equals("Finish")) {
            if(!matrix[playersRow][playersCol].equals("X")){
                matrix[playersRow][playersCol] = "-";
            }
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
            } else {
                command = scanner.nextLine();
                continue;
            }


            if (matrix[nextRow][nextCol].equals("-")) {
                playersRow = nextRow;
                playersCol = nextCol;
                treasurePath.append(command).append(", ");
                matrix[playersRow][playersCol] = "Y";
            } else if (matrix[nextRow][nextCol].equals("X")) {
                playersRow = nextRow;
                playersCol = nextCol;
                treasurePath.append(command).append(", ");
            }

            command = scanner.nextLine();

            if(command.equals("Finish") && matrix[playersRow][playersCol].equals("X")){
                hasFoundTreasure = true;
            }
//            System.out.println("-----------------");
//            printMatrix(matrix);
//            System.out.println("-----------------");
        }

        if (hasFoundTreasure) {
            treasurePath.deleteCharAt(treasurePath.lastIndexOf(", "));
            System.out.println("I've found the treasure!");
            System.out.println("The right path is " + treasurePath.toString());
        } else {
            System.out.println("The map is fake!");
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
