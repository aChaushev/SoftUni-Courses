package _05_MultidimensionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _01_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arraysCount = scanner.nextInt();
        int sizeOfArray = scanner.nextInt();

        int[][] firstMatrix = new int[arraysCount][sizeOfArray];

        for (int r = 0; r < arraysCount; r++) {
            for (int c = 0; c < sizeOfArray; c++) {
                firstMatrix[r][c] = scanner.nextInt();
            }
        }

        arraysCount = scanner.nextInt();
        sizeOfArray = scanner.nextInt();

        int[][] secondMatrix = new int[arraysCount][sizeOfArray];

        for (int r = 0; r < secondMatrix.length; r++) {
            for (int c = 0; c < secondMatrix[r].length; c++) {
                secondMatrix[r][c] = scanner.nextInt();
            }
        }

//            или

//        for (int i = 0; i < arraysCount; i++) {
//            int[] arr = new int[sizeOfArray];
//            for (int j = 0; j < sizeOfArray; j++) {
//                arr[j] = scanner.nextInt();
//            }
//            first[i] = arr;
//        }

//            или

//        for (int i = 0; i < arraysCount; i++) {
//            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
//                    .mapToInt(Integer::parseInt)
//                    .toArray();
//            first[i] = arr;
//        }

        boolean areEqual = areArraysEqual(firstMatrix, secondMatrix);


        System.out.println(areEqual ? "equal" : "not equal");
    }

    private static boolean areArraysEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int r = 0; r < firstMatrix.length; r++) {

            int[] firstArr = firstMatrix[r];
            int[] secondArr = secondMatrix[r];

            if (firstArr.length != secondArr.length) {
                return false;
            }

            for (int c = 0; c < firstArr.length; c++) {
                int firstNum = firstArr[c];
                int secondNum = secondArr[c];

                if (firstNum != secondNum) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
