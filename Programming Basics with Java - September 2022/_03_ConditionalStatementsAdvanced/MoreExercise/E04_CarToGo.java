package _03_ConditionalStatementsAdvanced.MoreExercise;

import java.util.Scanner;

public class E04_CarToGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	Първи ред – Бюджет – реално число в интервала [10.00...10000.00]
        //•	Втори ред –  Сезон – текст "Summer" или "Winter"
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String carClass = "";
        String carType = "";
        double price = 0;
        if (budget <= 100) {
            carClass = "Economy class";
            if (season.equals("Summer")) {
                carType = "Cabrio";
                price = budget * 0.35;
            } else if (season.equals("Winter")) {
                carType = "Jeep";
                price = budget * 0.65;
            }
        } else if (100 < budget && budget <= 500) {
            carClass = "Compact class";
            if (season.equals("Summer")) {
                carType = "Cabrio";
                price = budget * 0.45;
            } else if (season.equals("Winter")) {
                carType = "Jeep";
                price = budget * 0.80;
            }
        } else if (budget > 500) {
            carClass = "Luxury class";
            carType = "Jeep";
            price = budget * 0.90;
        }
        System.out.println(carClass);
        System.out.printf("%s - %.2f", carType, price);
    }
}
