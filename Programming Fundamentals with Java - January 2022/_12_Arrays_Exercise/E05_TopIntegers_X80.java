package _12_Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class E05_TopIntegers_X80 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxNum = Integer.MIN_VALUE;
        int indexMaxNum = 0;
        for (int i = 0; i < numbersArr.length; i++) {
            if (numbersArr[i] > maxNum) {
                maxNum = numbersArr[i];
                indexMaxNum = i;
            }
            if (i == numbersArr.length - 1) {
                System.out.print(maxNum + " ");
                i = indexMaxNum;
                maxNum = Integer.MIN_VALUE;
            }
        }
    }
}


