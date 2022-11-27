package _04_ForLoop.MoreExercise;

import java.util.Scanner;

public class E08_EqualPairs__Hard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());

        int previousSum = 0;
        int currentSum = 0;
        int diff = 0;
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 1; i <= input; i++) {
            int currentNum1 = Integer.parseInt(scanner.nextLine());
            int currentNum2 = Integer.parseInt(scanner.nextLine());
            currentSum = currentNum1 + currentNum2;
            if (i > 1) {
                diff = Math.abs(previousSum - currentSum);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
            previousSum = currentSum;
        }

        if (diff == 0) {
            System.out.printf("Yes, value=%d", currentSum);
        } else {
            System.out.printf("No, maxdiff=%d", maxDiff);
        }
    }
}
