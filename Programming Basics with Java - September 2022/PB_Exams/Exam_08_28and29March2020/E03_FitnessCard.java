package PB_Exams.Exam_08_28and29March2020;

import java.util.Scanner;

public class E03_FitnessCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        char gender = scanner.nextLine().charAt(0);
        int age = Integer.parseInt(scanner.nextLine());
        String sport = scanner.nextLine();

        double price = 0;
        if (sport.equals("Gym")) {
            if (gender == 'm') {
                price = 42;
            } else if (gender == 'f') {
                price = 35;
            }
        } else if (sport.equals("Boxing")) {
            if (gender == 'm') {
                price = 41;
            } else if (gender == 'f') {
                price = 37;
            }
        } else if (sport.equals("Yoga")) {
            if (gender == 'm') {
                price = 45;
            } else if (gender == 'f') {
                price = 42;
            }
        } else if (sport.equals("Zumba")) {
            if (gender == 'm') {
                price = 34;
            } else if (gender == 'f') {
                price = 31;
            }
        } else if (sport.equals("Dances")) {
            if (gender == 'm') {
                price = 51;
            } else if (gender == 'f') {
                price = 53;
            }
        } else if (sport.equals("Pilates")) {
            if (gender == 'm') {
                price = 39;
            } else if (gender == 'f') {
                price = 37;
            }
        }
        if (age <= 19) {
            price *= 0.8;
        }
        if (budget >= price) {
            System.out.printf("You purchased a 1 month pass for %s.", sport);
        } else {
            System.out.printf("You don't have enough money! You need $%.2f more.", price - budget);
        }
    }
}
