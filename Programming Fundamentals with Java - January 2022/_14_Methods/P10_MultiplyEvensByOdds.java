package _14_Methods;

import java.util.Scanner;

public class P10_MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Math.abs(Integer.parseInt(scanner.nextLine()));
        System.out.println(getMultipleOfEvenAndOdd(num));

    }

    public static int getMultipleOfEvenAndOdd(int num) {
        int evenSum = getSumOfEvenDigits(num);
        int oddSum = getSumOfOddDigits(num);

        return evenSum * oddSum;
    }

    public static int getSumOfEvenDigits(int num) {
        int evenSum = 0;
        while (num > 0) {
            int currentDigit = num % 10;
            if (currentDigit % 2 == 0) {
                evenSum += currentDigit;
            }
            num /= 10;
        }
        return evenSum;
    }

    public static int getSumOfOddDigits(int num) {
        int oddSum = 0;
        while (num > 0) {
            int currentDigit = num % 10;
            if (currentDigit % 2 != 0) {
                oddSum += currentDigit;
            }
            num /= 10;
        }
        return oddSum;
    }
}
