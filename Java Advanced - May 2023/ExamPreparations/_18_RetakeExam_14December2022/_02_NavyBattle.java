package ExamPreparations._18_RetakeExam_14December2022;

import java.util.Scanner;

public class _02_NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //размер на бойното поле -> квадрат

        String[][] matrix = new String[n][n];

        fillMatrix(matrix, scanner);

        //къде се намира подводницата "S" на бойното поле
        int submarineRow = -1;
        int submarineCol = -1;
        int hitsCount = 0; // колко пъти подводницата е попаднала на мина
        int battleCruisersCount = 0; //колко бойни кораби са унищужени
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col].equals("S")) {
                    submarineRow = row;
                    submarineCol = col;
                    break;
                }
            }
        }

        //The commands will be "up", "down", "left" and "right".
        String command = scanner.nextLine();

        while (true) {
            // започваме движение
            matrix[submarineRow][submarineCol] = "-";
            if (command.equals("up")) {
                submarineRow--;
            } else if (command.equals("down")) {
                submarineRow++;
            } else if (command.equals("left")) {
                submarineCol--;
            } else if (command.equals("right")) {
                submarineCol++;
            }
            // имаме новата позиция на Submarine
            String submarinePosition = matrix[submarineRow][submarineCol];
            if (submarinePosition.equals("-")) {
                matrix[submarineRow][submarineCol] = "S";

            } else if (submarinePosition.equals("*")) {
                matrix[submarineRow][submarineCol] = "S";
                hitsCount++;

                if (hitsCount == 3) {
                    // подводницата е унищужена
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!\n", submarineRow, submarineCol);
                    break;
                }


            } else if (submarinePosition.equals("C")) {
                matrix[submarineRow][submarineCol] = "S";
                battleCruisersCount++;

                if(battleCruisersCount == 3){
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    break;
                }
            }

            command = scanner.nextLine();
        }

        printMatrix(matrix);

    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            //scanner.nextLine() -> "*--*-"
            //scanner.nextLine().split(" ") -> ["*", "-", "-"]
            matrix[row] = scanner.nextLine().split("");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }

}
