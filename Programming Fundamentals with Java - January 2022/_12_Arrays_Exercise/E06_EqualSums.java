package _12_Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class E06_EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean notExist = true;
        for (int i = 0; i < numbersArr.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += numbersArr[j];
            }
            for (int j = i + 1; j < numbersArr.length; j++) {
                rightSum += numbersArr[j];
            }
            if (rightSum == leftSum) {
                System.out.println(i);
                notExist = false;
            }
        }
        if (notExist) {
            System.out.println("no");
        }
    }
}
