package _05_BasicSyntax_Exercise;

import java.util.Scanner;

public class P03_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();

        double singlePrice = 0;
        double totalPrice = 0;
        if (groupType.equals("Students")) {
            if (dayOfWeek.equals("Friday")) {
                singlePrice = 8.45;
            } else if (dayOfWeek.equals("Saturday")) {
                singlePrice = 9.80;
            } else if (dayOfWeek.equals("Sunday")) {
                singlePrice = 10.46;
            }
            totalPrice = singlePrice * people;
            if (people >= 30) {
                totalPrice -= totalPrice * 0.15;
            }
        } else if (groupType.equals("Business")) {
            if (dayOfWeek.equals("Friday")) {
                singlePrice = 10.90;
            } else if (dayOfWeek.equals("Saturday")) {
                singlePrice = 15.60;
            } else if (dayOfWeek.equals("Sunday")) {
                singlePrice = 16;
            }
            if (people >= 100) {
                totalPrice = singlePrice * (people - 10);
            } else {
                totalPrice = singlePrice * people;
            }
        } else if (groupType.equals("Regular")) {
            if (dayOfWeek.equals("Friday")) {
                singlePrice = 15;
            } else if (dayOfWeek.equals("Saturday")) {
                singlePrice = 20;
            } else if (dayOfWeek.equals("Sunday")) {
                singlePrice = 22.50;
            }
            totalPrice = singlePrice * people;
            if (10 <= people && people <= 20) {
                totalPrice -= totalPrice * 0.05;
            }
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
