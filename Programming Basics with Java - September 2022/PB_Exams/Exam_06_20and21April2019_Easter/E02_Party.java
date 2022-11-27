package PB_Exams.Exam_06_20and21April2019_Easter;

import java.util.Scanner;

public class E02_Party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int guestsCnt = Integer.parseInt(scanner.nextLine());
        double onePersonEnvelope = Double.parseDouble(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());

        if (10 <= guestsCnt && guestsCnt <= 15) {
            onePersonEnvelope *= 0.85;
        } else if (15 < guestsCnt && guestsCnt <= 20) {
            onePersonEnvelope *= 0.8;
        } else if (20 < guestsCnt) {
            onePersonEnvelope *= 0.75;
        }
        double cakePrice = budget * 0.1;
        double totalExpense = guestsCnt * onePersonEnvelope + cakePrice;
        double diff = Math.abs(budget - totalExpense);
        if (budget >= totalExpense) {
            System.out.printf("It is party time! %.2f leva left.", diff);
        } else {
            System.out.printf("No party! %.2f leva needed.", diff);
        }
    }
}
