package _02_ConditionalStatements.Exercise;

import java.util.Scanner;

public class E02BonusScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int points = Integer.parseInt(scanner.nextLine());

        double bonus = 0;
        if (points <= 100) {
            bonus = 5;
        } else if (points > 1000) {
            bonus = 0.1 * points;
        } else {
            bonus = 0.2 * points;
        }

        if (points % 2 == 0) {
            bonus = bonus + 1;
        } else if (points % 10 == 5) {
            bonus = bonus + 2;
        }

        System.out.println(bonus);
        System.out.println(points + bonus);
    }
}
