package _04_ForLoop.MoreExercise;

import java.util.Scanner;

public class E11_OddEvenPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        double oddSum = 0;
        double oddMin = Integer.MAX_VALUE;
        double oddMax = Integer.MIN_VALUE;
        double evenSum = 0;
        double evenMin = Integer.MAX_VALUE;
        double evenMax = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            double currentNum = Double.parseDouble(scanner.nextLine());
            if (i % 2 == 0) {
                evenSum += currentNum;
                if (currentNum > evenMax) {
                    evenMax = currentNum;
                }
                if (currentNum < evenMin) {
                    evenMin = currentNum;
                }
            } else {
                oddSum += currentNum;
                if (currentNum > oddMax) {
                    oddMax = currentNum;
                }
                if (currentNum < oddMin) {
                    oddMin = currentNum;
                }
            }
        }
        System.out.printf("OddSum=%.2f,%n", oddSum);
        if (oddMin == Integer.MAX_VALUE || oddMax == Integer.MIN_VALUE) {
            System.out.println("OddMin=No,");
            System.out.println("OddMax=No,");
        } else {
            System.out.printf("OddMin=%.2f,%n", oddMin);
            System.out.printf("OddMax=%.2f,%n", oddMax);
        }
        System.out.printf("EvenSum=%.2f,%n", evenSum);
        if (evenMin == Integer.MAX_VALUE || evenMax == Integer.MIN_VALUE) {
            System.out.println("EvenMin=No,");
            System.out.println("EvenMax=No");
        } else {
            System.out.printf("EvenMin=%.2f,%n", evenMin);
            System.out.printf("EvenMax=%.2f%n", evenMax);
        }
    }
}
