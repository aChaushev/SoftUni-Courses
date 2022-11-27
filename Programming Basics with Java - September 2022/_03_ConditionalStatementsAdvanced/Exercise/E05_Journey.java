package _03_ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class E05_Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Първи ред – Бюджет, реално число в интервала [10.00...5000.00].
        //•	Втори ред – Един от двата възможни сезона: "summer" или "winter"
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();


        String destination = "";
        if (budget <= 100) {
            destination = "Bulgaria";
            if (season.equals("summer")) {
                budget = budget * 0.3;
            } else if (season.equals("winter")) {
                budget = budget * 0.7;
            }

        } else if (budget <= 1000) {
            destination = "Balkans";
            if (season.equals("summer")) {
                budget = budget * 0.4;
            } else if (season.equals("winter")) {
                budget = budget * 0.8;
            }
        } else if (budget > 1000) {
            destination = "Europe";
            budget = budget * 0.9;
        }

        String restingPlace = "";
        if (destination.equals("Europe") || season.equals("winter")){
            restingPlace = "Hotel";
        } else if (season.equals("summer")) {
            restingPlace = "Camp";
        }
        //•	Първи ред – "Somewhere in {дестинация}" измежду "Bulgaria", "Balkans" и "Europe"
        //•	Втори ред – "{Вид почивка} – {Похарчена сума}"

        System.out.printf("Somewhere in %s %n", destination);
        System.out.printf("%s - %.2f", restingPlace, budget);
    }
}
