package PreliminaryExam_21_22Oct;

import java.util.Scanner;

public class E02_BraceletStand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pocketMoneyPerDay = Double.parseDouble(scanner.nextLine());
        double moneyEarnedPerDay = Double.parseDouble(scanner.nextLine());
        double allExpenses = Double.parseDouble(scanner.nextLine());
        double giftPrice = Double.parseDouble(scanner.nextLine());

        double allMoneySaved = 5 * (pocketMoneyPerDay + moneyEarnedPerDay) - allExpenses;
        if (allMoneySaved >= giftPrice) {
            System.out.printf("Profit: %.2f BGN, the gift has been purchased.", allMoneySaved);
        } else {
            System.out.printf("Insufficient money: %.2f BGN.", giftPrice - allMoneySaved);
        }
    }
}
