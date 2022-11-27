package PB_Exams.Exam_03_15and16June2019;

import java.util.Scanner;

public class E03_MovieDestination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1.	Бюджет на филма – реално число в диапазона [100 000.0… 2 000 000.0]
        //2.	Дестинация – текст, с възможности "Dubai", "Sofia" и "London"
        //3.	Сезон – текст, с възможности "Summer" и "Winter"
        //4.	Брой дни  – цяло число в диапазона [1… 40]
        double budget = Double.parseDouble(scanner.nextLine());
        String destination = scanner.nextLine();
        String season = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());

        //Дестинация
        //Сезон	    Dubai	    Sofia	    London
        //Winter	45 000 lv.	17 000 lv.	24 000 lv.
        //Summer	40 000 lv.	12 500 lv.	20 250 lv.
        double shootingDayPrice = 0;
        if (destination.equals("Dubai")) {
            if (season.equals("Winter")) {
                shootingDayPrice = 45000 * 0.7;
            } else if (season.equals("Summer")) {
                shootingDayPrice = 40000 * 0.7;
            }
        } else if (destination.equals("Sofia")) {
            if (season.equals("Winter")) {
                shootingDayPrice = 17000 * 1.25;
            } else if (season.equals("Summer")) {
                shootingDayPrice = 12500 * 1.25;
            }
        } else if (destination.equals("London")) {
            if (season.equals("Winter")) {
                shootingDayPrice = 24000;
            } else if (season.equals("Summer")) {
                shootingDayPrice = 20250;
            }
        }
        double expenses = days * shootingDayPrice;
        double diff = Math.abs(budget - expenses);
        if (budget >= expenses) {
            System.out.printf("The budget for the movie is enough! We have %.2f leva left!", diff);
        } else {
            System.out.printf("The director needs %.2f leva more!", diff);
        }
    }
}
