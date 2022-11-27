package _05_WhileLoop.MoreExercise;

import java.util.Scanner;

public class E02_ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int charitySum = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        int sum = 0;
        int evenOddCounter = 0;
        int evenCounter = 0;
        double evenSum = 0;
        int oddCounter = 0;
        double oddSum = 0;
        while (!input.equals("End")) {
            evenOddCounter++;
            int income = Integer.parseInt(input);
            if (evenOddCounter % 2 == 0) {
                if (income < 10) {
                    System.out.println("Error in transaction!");
                } else {
                    sum += income;
                    evenSum += income;
                    evenCounter++;
                    System.out.println("Product sold!");
                }
            } else {
                if (income > 100) {
                    System.out.println("Error in transaction!");
                } else {
                    sum += income;
                    oddSum += income;
                    oddCounter++;
                    System.out.println("Product sold!");
                }
            }
            if (sum >= charitySum) {
                break;
            }
            input = scanner.nextLine();
        }
        if (input.equals("End")) {
            System.out.println("Failed to collect required money for charity.");
        } else {
            System.out.printf("Average CS: %.2f%n", oddSum / oddCounter);
            System.out.printf("Average CC: %.2f", evenSum / evenCounter);
        }
    }
}
