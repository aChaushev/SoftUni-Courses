package _02_ConditionalStatements.Exercise;

import java.util.Scanner;

public class E04ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double excursionPrice = Double.parseDouble(scanner.nextLine());
        int puzzles = Integer.parseInt(scanner.nextLine());
        int dolls = Integer.parseInt(scanner.nextLine());
        int bears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());

        int toysNumber = puzzles + dolls + bears + minions + trucks;
        double toysPrice = (puzzles * 2.60) + (dolls * 3) + (bears * 4.10) + (minions * 8.20) + (trucks * 2);

        if (toysNumber >= 50) {
            toysPrice = toysPrice - toysPrice * 0.25;
        }
        toysPrice = toysPrice - toysPrice * 0.10;

        double result = Math.abs(toysPrice - excursionPrice);
        if (toysPrice >= excursionPrice) {
            System.out.printf("Yes! %.2f lv left.", result);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", result);
        }
    }
}
