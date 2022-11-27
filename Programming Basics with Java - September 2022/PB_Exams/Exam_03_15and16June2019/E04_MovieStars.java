package PB_Exams.Exam_03_15and16June2019;

import java.util.Scanner;

public class E04_MovieStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("ACTION")) {
            if (input.length() > 15) {
                budget -= budget * 0.2;
            } else {
                double pay = Double.parseDouble(scanner.nextLine());
                budget -= pay;
            }
            if (budget < 0) {
                break;
            }
            input = scanner.nextLine();
        }
        if (budget < 0) {
            System.out.printf("We need %.2f leva for our actors.", Math.abs(budget));
        } else {
            System.out.printf("We are left with %.2f leva.", budget);
        }
    }
}
