package PB_Exams.Exam_04_2and3May2019;

import java.util.Scanner;

public class E02_Safari {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double fuelAmount = Double.parseDouble(scanner.nextLine());
        String dayOfWeek = scanner.nextLine();

        double expenses = fuelAmount * 2.1 + 100;
        if (dayOfWeek.equals("Saturday")) {
            expenses *= 0.9;
        } else if (dayOfWeek.equals("Sunday")) {
            expenses *= 0.8;
        }

        double diff = Math.abs(budget - expenses);
        if (budget >= expenses) {
            System.out.printf("Safari time! Money left: %.2f lv. ", diff);
        } else {
            System.out.printf("Not enough money! Money needed: %.2f lv.", diff);
        }
    }
}
