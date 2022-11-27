package _03_ConditionalStatementsAdvanced.MoreExercise;

import java.util.Scanner;

public class E06_TruckDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	Първи ред – Сезон – текст "Spring", "Summer", "Autumn" или "Winter"
        //•	Втори ред –  Километри на месец – реално число в интервала [10.00...20000.00]
        String season = scanner.nextLine();
        double kmPerMonth = Double.parseDouble(scanner.nextLine());
        //	                            Пролет/Есен	    Лято	        Зима
        //км на месец <= 5000	        0.75 лв./км	    0.90 лв./км	    1.05 лв./км
        //5000 < км на месец <= 10000	0.95 лв./км	    1.10 лв./км	    1.25 лв./км
        //10000 < км на месец <= 20000	1.45 лв./км – за който и да е сезон
        double kmPerSeason = kmPerMonth * 4;
        double salaryPerSeason = 0;
        if (kmPerMonth <= 5000) {
            if (season.equals("Spring") || season.equals("Autumn")) {
                salaryPerSeason = kmPerSeason * 0.75;
            } else if (season.equals("Summer")) {
                salaryPerSeason = kmPerSeason * 0.90;
            } else if (season.equals("Winter")) {
                salaryPerSeason = kmPerSeason * 1.05;
            }
        } else if (5000 < kmPerMonth && kmPerMonth <= 10000) {
            if (season.equals("Spring") || season.equals("Autumn")) {
                salaryPerSeason = kmPerSeason * 0.95;
            } else if (season.equals("Summer")) {
                salaryPerSeason = kmPerSeason * 1.10;
            } else if (season.equals("Winter")) {
                salaryPerSeason = kmPerSeason * 1.25;
            }
        } else if (10000 < kmPerMonth && kmPerMonth <= 20000) {
            salaryPerSeason = kmPerSeason * 1.45;
        }
        salaryPerSeason -= salaryPerSeason * 0.1;
        System.out.printf("%.2f", salaryPerSeason);
    }
}
