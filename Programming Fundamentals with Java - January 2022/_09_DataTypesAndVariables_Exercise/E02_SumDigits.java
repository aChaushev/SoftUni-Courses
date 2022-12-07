package _09_DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class E02_SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            sum += lastDigit;
            number /= 10;
        }
        System.out.println(sum);
    }
}
