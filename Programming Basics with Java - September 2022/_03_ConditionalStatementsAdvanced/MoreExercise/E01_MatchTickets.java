package _03_ConditionalStatementsAdvanced.MoreExercise;

import java.util.Scanner;

public class E01_MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	На първия ред е бюджетът – реално число в интервала [1 000.00 ... 1 000 000.00]
        //•	На втория ред е категорията – "VIP" или "Normal"
        //•	На третия ред е броят на хората в групата – цяло число в интервала [1 ... 200]
        double budget = Double.parseDouble(scanner.nextLine());
        String category = scanner.nextLine();
        int people = Integer.parseInt(scanner.nextLine());

        //•	От 1 до 4 – 75% от бюджета.
        //•	От 5 до 9 – 60% от бюджета.
        //•	От 10 до 24 – 50% от бюджета.
        //•	От 25 до 49 – 40% от бюджета.
        //•	50 или повече – 25% от бюджета.
        double transport = 0;
        if (people <= 4) {
            transport = budget * 0.75;
        } else if (people <= 9) {
            transport = budget * 0.60;
        } else if (people <= 24) {
            transport = budget * 0.50;
        } else if (people <= 49) {
            transport = budget * 0.40;
        } else {
            transport = budget * 0.25;
        }

        //•	IP – 499.99 лева.
        //•	Normal – 249.99 лева.
        double moneyForTickets = budget - transport;
        double ticketsCost = 0;
        if (category.equals("VIP")) {
            ticketsCost = people * 499.99;
        } else if (category.equals("Normal")) {
            ticketsCost = people * 249.99;
        }

        double diff = Math.abs(moneyForTickets - ticketsCost);
        if (moneyForTickets >= ticketsCost) {
            System.out.printf("Yes! You have %.2f leva left.", diff);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", diff);
        }
    }
}
