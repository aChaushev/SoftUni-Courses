package _06_MultidimensionalArrays_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Reading
        //From top to bottom -> row++;
        //From bottom to top -> row--;
        //From left to right -> col++;
        //From right to left -> col--;

        String rotation = scanner.nextLine();
        int rotationNum = Integer.parseInt(rotation.split("[()]")[1]);
        int angleOfRotation = rotationNum % 360;
        String input = scanner.nextLine();

        List<String> wordsList = new ArrayList<>();

        int maxLength = Integer.MIN_VALUE;
        while (!input.equals("END")) {
            wordsList.add(input);
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
            input = scanner.nextLine();
        }

        int rows = wordsList.size();
        int cols = maxLength;

        char[][] matrix = new char[rows][cols];

        for (int r = 0; r < rows; r++) {
            String currentWord = wordsList.get(r);

            for (int c = 0; c < cols; c++) {
                if (c < currentWord.length()) {
                    char currentChar = currentWord.charAt(c);
                    matrix[r][c] = currentChar;
                } else {
                    matrix[r][c] = ' ';
                }
            }
        }

        if (angleOfRotation == 0) {
            for (char[] arr : matrix) {
                for (char n : arr) {
                    System.out.print(n);
                }
                System.out.println();
            }
        } else if (angleOfRotation == 90) {
            for (int c = 0; c < cols; c++) {
                for (int r = rows - 1; r >= 0; r--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }


        } else if (angleOfRotation == 180) {
            for (int r = rows - 1; r >= 0; r--) {
                for (int c = cols - 1; c >= 0; c--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        } else if (angleOfRotation == 270) {
            for (int c = cols - 1; c >= 0; c--) {
                for (int r = 0; r < rows; r++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        }

    }
}
