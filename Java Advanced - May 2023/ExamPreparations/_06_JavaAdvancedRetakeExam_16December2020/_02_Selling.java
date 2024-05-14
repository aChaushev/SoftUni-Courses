package ExamPreparations._06_JavaAdvancedRetakeExam_16December2020;

import java.util.Scanner;

public class _02_Selling {

    public static int playersRow;
    public static int playersCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[matrixSize][matrixSize];

        fillMatrix(scanner, matrixSize, matrix);

        int moneyCollected = 0;

        while (moneyCollected < 50) {
            String command = scanner.nextLine();

            matrix[playersRow][playersCol] = "-";

            if (command.equals("up") && playersRow > 0) {
                playersRow--;
            } else if (command.equals("down") && playersRow < matrix.length - 1) {
                playersRow++;
            } else if (command.equals("left") && playersCol > 0) {
                playersCol--;
            } else if (command.equals("right") && playersCol < matrix[playersRow].length - 1) {
                playersCol++;
            } else {
                System.out.println("Bad news, you are out of the bakery.");
                break;
            }

            String currentPosition = matrix[playersRow][playersCol];
            if (Character.isDigit(currentPosition.charAt(0))) {
                moneyCollected += Integer.parseInt(currentPosition);
            } else if (currentPosition.equals("O")) {
                matrix[playersRow][playersCol] = "-";
                moveToTheOtherPillar(matrix);
            }

            matrix[playersRow][playersCol] = "S";

        }

        if (moneyCollected >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.printf("Money: %d\n", moneyCollected);

        printMatrix(matrix);

    }

    private static void moveToTheOtherPillar(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("O")) {
                    playersRow = row;
                    playersCol = col;
                    break;
                }
            }
        }
    }

    private static void fillMatrix(Scanner scanner, int matrixSize, String[][] matrix) {
        for (int row = 0; row < matrixSize; row++) {
            String matrixRow = scanner.nextLine();
            matrix[row] = matrixRow.split("");

            if (matrixRow.contains("S")) {
                playersRow = row;
                playersCol = matrixRow.indexOf("S");

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
