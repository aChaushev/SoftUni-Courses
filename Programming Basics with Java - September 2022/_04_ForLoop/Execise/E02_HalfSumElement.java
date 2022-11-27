package _04_ForLoop.Execise;

import java.util.Scanner;

public class E02_HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int maxNum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            sum += currentNum;
            if (currentNum > maxNum) {
                maxNum = currentNum;
            }
        }
        sum = sum - maxNum;
        int diff = Math.abs(maxNum - sum);
        if (sum == maxNum) {
            System.out.printf("Yes%nSum = %d", maxNum);
        } else {
            System.out.printf("No%nDiff = %d", diff);
        }
    }
}
