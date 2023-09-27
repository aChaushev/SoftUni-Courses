package _06_MultidimensionalArrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _12_TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        char[][] matrix = new char[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }

        char newColor = scanner.nextLine().charAt(0); //елемента скойто изкаме да заместим зададените елементи

        int[] clickedPixels = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray(); // индесксите на елемента, чиито еднакви искаме да оцветим

        int clickedRow = clickedPixels[0];
        int clickedCol = clickedPixels[1];

        char oldColor = matrix[clickedRow][clickedCol]; //емелемента, който искаме да оцветим

        paint(matrix, newColor, oldColor, clickedRow, clickedCol);

        for (char[] line : matrix) {
            for (char c : line) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void paint(char[][] matrix, char newColor, char oldColor, int clickedRow, int clickedCol) {

        if (isOutOfBounds(matrix, clickedRow, clickedCol) || matrix[clickedRow][clickedCol] != oldColor) {
            // ако излезем извън матрицата или на мясторо което сме оцветили е вече оцветено
            // условие за спиране на рекурсията -> дъно
            return;
        }

        matrix[clickedRow][clickedCol] = newColor;

//        ЗА ПРЕГЛЕД НА СТЪПКИТЕ С КОИТО ПОПЪЛВА/ОЦВЕТЯВА РЕКУРСИЯТА
//        for (char[] line : matrix) {
//            for (char c : line) {
//                System.out.print(c);
//            }
//            System.out.println();
//        }
//
//        System.out.println();

        // всеки път рекурсията ще ходи нагоре, докато сигне дъно и тн.
        paint(matrix, newColor, oldColor, clickedRow + 1, clickedCol);
        paint(matrix, newColor, oldColor, clickedRow - 1, clickedCol);
        paint(matrix, newColor, oldColor, clickedRow, clickedCol + 1);
        paint(matrix, newColor, oldColor, clickedRow, clickedCol - 1);

    }

    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }
}
