package PB_Exams.Exam_02_6and7April2019;

import java.util.Scanner;

public class E02_GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int statists = Integer.parseInt(scanner.nextLine());
        double statistOutfit = Double.parseDouble(scanner.nextLine());

        double decor = budget * 0.1;
        if (statists > 150) {
            statistOutfit = statistOutfit * 0.9;
        }
        double allExpenses = statists * statistOutfit + decor;
        double diff = Math.abs(budget - allExpenses);

        if (budget < allExpenses) {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", diff);
        } else {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", diff);
        }
    }
}
