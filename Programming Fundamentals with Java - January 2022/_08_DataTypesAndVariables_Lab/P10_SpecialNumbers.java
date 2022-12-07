package _08_DataTypesAndVariables_Lab;

import java.util.Scanner;

public class P10_SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            int digitSum = 0;
            int currentNum = i;
            while (currentNum > 0) {
                int currentDigit = currentNum % 10;
                digitSum += currentDigit;
                currentNum /= 10;
            }
            if (digitSum == 5 || digitSum == 7 || digitSum == 11) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }
        }
    }
}
