package _15_Methods_Exercise;

import java.util.Scanner;

public class E08_FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        long fact1 = calcFactorial(num1);
        long fact2 = calcFactorial(num2);
        double divisionResult = fact1 * 1.0 / fact2;

        System.out.printf("%.2f", divisionResult);
    }

    public static long calcFactorial(int num) {
        // 5! = 1 * 2 * 3 * 4 * 5 = 120
        long fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }
}
