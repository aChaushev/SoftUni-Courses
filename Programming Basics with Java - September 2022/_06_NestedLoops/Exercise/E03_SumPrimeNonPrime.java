package _06_NestedLoops.Exercise;

import java.util.Scanner;

public class E03_SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int primeSum = 0;
        int nonPrimeSum = 0;
        while (!input.equals("stop")) {
            int currentNum = Integer.parseInt(input);

            if (currentNum < 0) {
                System.out.println("Number is negative.");
                input = scanner.nextLine();
                continue;
            }
            int counter = 0;
            for (int i = 1; i <= currentNum; i++) {
                if (currentNum % i == 0) {
                    counter++;
                }
            }

            if (counter == 2) {
                primeSum += currentNum;
            } else {
                nonPrimeSum += currentNum;
            }

            input = scanner.nextLine();
        }
        System.out.println("Sum of all prime numbers is: " + primeSum);
        System.out.println("Sum of all non prime numbers is: " + nonPrimeSum);
    }
}
