package _11_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P06_EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean areEqual = true;
        int itemSum = 0;
        //int diffIndex = 0; -> (if (firstArr[i] != secondArr[i]) -> diffIndex = i;
        for (int i = 0; i < firstArr.length; i++) {
            itemSum += firstArr[i];
            if (firstArr[i] != secondArr[i]) {
                areEqual = false;
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                break;
            }
        }
        if (areEqual) {
            System.out.printf("Arrays are identical. Sum: %d", itemSum);
        }
    }
}
