package _05_BasicSyntax_Exercise;

import java.util.Scanner;

public class P06_StrongNumber_while {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int startNum = num;
        int factorialSum = 0;
        while (num > 0) {
            int lastDigit = num % 10;
            int currentFactorial = 1;
            for (int j = 1; j <= lastDigit; j++) {
                currentFactorial *= j;
            }
            factorialSum += currentFactorial;
            num /= 10;
        }
        if (factorialSum == startNum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
