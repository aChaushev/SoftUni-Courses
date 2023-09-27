package _06_MultidimensionalArrays_Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _07_Crossfire_List {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> matrix = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            matrix.add(new ArrayList<>());
            for (int c = 0; c < cols; c++) {
                matrix.get(r).add(r * cols + (c + 1));
            }
        }


        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            int[] commandArr = Arrays.stream(command.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int row = commandArr[0];
            int col = commandArr[1];
            int radius = commandArr[2];

            // премахване по колона, ако има елемент
            for (int r = row - radius; r <= row + radius; r++) {
                if (isValidCoordinate(matrix, r, col) && r != row) {
                    matrix.get(r).remove(col);
                }
            }

            // премахване по колона, ако има елемент
            for (int c = col + radius; c >= col - radius; c--) {
                if (isValidCoordinate(matrix, row, c)) {
                    matrix.get(row).remove(c);
                }

            }
            // при останали празни редове премахва реда (под-листа)
            for (int i = 0; i < matrix.size(); i++) {
                List<Integer> arr = matrix.get(i);
                if (arr.isEmpty()) {
                    matrix.remove(arr);
                }
            }
            command = scanner.nextLine();
        }

        for (List<Integer> arr : matrix) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

    }

    private static boolean isValidCoordinate(List<List<Integer>> matrix, int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();

    }
}
