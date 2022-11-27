package _04_ForLoop.MoreExercise;

import java.util.Scanner;

public class E01_BackToThePast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	Наследените пари – реално число в интервала [1.00 ... 1 000 000.00]
        //•	Годината, до която трябва да живее (включително) – цяло число в интервала [1801 ... 1900]
        double inheritedMoney = Double.parseDouble(scanner.nextLine());
        int yearToLive = Integer.parseInt(scanner.nextLine());

        double moneyToLive = 0;
        for (int i = 0; i <= (yearToLive - 1800); i++) {
            if (i % 2 == 0) {
                moneyToLive += 12000;
            } else {
                moneyToLive += 12000 + 50 * (i + 18);
            }
        }
        double diff = Math.abs(inheritedMoney - moneyToLive);
        if (inheritedMoney >= moneyToLive) {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", diff);
        } else {
            System.out.printf("He will need %.2f dollars to survive.", diff);
        }
    }
}
