package PB_Exams.Exam_06_20and21April2019_Easter;

import java.util.Scanner;

public class E02_Guests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int guests = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double easterBreadsCnt = Math.ceil(guests * 1.0 / 3);
        int eggsCnt = guests * 2;
        double expense = easterBreadsCnt * 4 + eggsCnt * 0.45;
        double diff = Math.abs(budget - expense);
        if (budget >= expense) {
            System.out.printf("Lyubo bought %.0f Easter bread and %d eggs.%n", easterBreadsCnt, eggsCnt);
            System.out.printf("He has %.2f lv. left.", diff);
        } else {
            System.out.println("Lyubo doesn't have enough money.");
            System.out.printf("He needs %.2f lv. more.", diff);
        }
    }
}
