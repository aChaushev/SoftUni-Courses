package _02_ConditionalStatements.Exercise;

import java.util.Scanner;

public class E05GodzilaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int statists = Integer.parseInt(scanner.nextLine());
        double oneStatistOutfit = Double.parseDouble(scanner.nextLine());

        double decor = budget * 0.10;
        if (statists > 150) {
            oneStatistOutfit = oneStatistOutfit - oneStatistOutfit * 0.10;
        }

        double totalExpense = statists * oneStatistOutfit + decor;
        if (totalExpense > budget) {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", totalExpense - budget);
        } else {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", budget - totalExpense);
        }
    }
}
