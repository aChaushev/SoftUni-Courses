package _05_BasicSyntax_Exercise;

import java.util.Scanner;

public class P06_StrongNumber_for {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int factorialSum = 0;
        int numLength = input.length();
        int num = Integer.parseInt(input);
        for (int i = 1; i <= numLength; i++) {      // while (num > 0) {  ->
            int currentDigit = num % 10;
            int currentFactorial = 1;
            for (int j = 1; j <= currentDigit; j++) {
                currentFactorial *= j;
            }
            factorialSum += currentFactorial;
            num /= 10;
        }
        if (factorialSum == Integer.parseInt(input)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
