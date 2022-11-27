package PB_Exams.Exam_04_2and3May2019;

import java.util.Scanner;

public class E06_VetParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());

        double totalSum = 0;
        for (int d = 1; d <= days; d++) {
            double dayPay = 0;
            for (int h = 1; h <= hours; h++) {
                if (d % 2 == 0 && h % 2 != 0) {
                    dayPay += 2.50;
                } else if (d % 2 != 0 && h % 2 == 0) {
                    dayPay += 1.25;
                } else {
                    dayPay += 1;
                }
            }
            System.out.printf("Day: %d - %.2f leva%n", d, dayPay);
            totalSum += dayPay;
        }
        System.out.printf("Total: %.2f leva", totalSum);
    }
}
