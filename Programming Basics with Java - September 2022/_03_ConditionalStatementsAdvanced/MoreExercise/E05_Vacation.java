package _03_ConditionalStatementsAdvanced.MoreExercise;

import java.util.Scanner;

public class E05_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String placesToStay = "";
        String location = "";
        double price = 0;
        if (budget <= 1000) {
            placesToStay = "Camp";
            if (season.equals("Summer")) {
                location = "Alaska";
                price = budget * 0.65;
            } else if (season.equals("Winter")) {
                location = "Morocco";
                price = budget * 0.45;
            }
        } else if (1000 < budget && budget <= 3000) {
            placesToStay = "Hut";
            if (season.equals("Summer")) {
                location = "Alaska";
                price = budget * 0.80;
            } else if (season.equals("Winter")) {
                location = "Morocco";
                price = budget * 0.60;
            }
        } else if (budget > 3000) {
            placesToStay = "Hotel";
            price = budget * 0.90;
            if (season.equals("Summer")) {
                location = "Alaska";
            } else if (season.equals("Winter")) {
                location = "Morocco";
            }
        }
        System.out.printf("%s - %s - %.2f", location, placesToStay, price);
    }
}
