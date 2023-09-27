package _05_MultidimensionalArrays_Lab;

import java.util.Scanner;

public class _02_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = scanner.nextInt();
        int col = scanner.nextInt();

        int[][] matrix = new int[row][col];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = scanner.nextInt();
            }
        }

        int targetNum = scanner.nextInt();

        //проверка за числото
//        StringBuilder indexesFound = new StringBuilder();
        boolean isFound = false;
        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[r].length; c++){
                if(matrix[r][c] == targetNum){
//                    indexesFound
//                            .append(r)
//                            .append(" ")
//                            .append(c)
//                            .append(System.lineSeparator());
                    System.out.println(r + " " + c);
                    isFound = true;
                }
            }
        }

        if(!isFound){
            System.out.println("not found");
        }
//        System.out.println(indexesFound.isEmpty() ? "not found" : indexesFound);

    }
}
