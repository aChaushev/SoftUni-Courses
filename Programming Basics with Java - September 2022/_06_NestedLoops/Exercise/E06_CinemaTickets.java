package _06_NestedLoops.Exercise;

import java.util.Scanner;

public class E06_CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int studentSeating = 0;
        int standardSeating = 0;
        int kidSeating = 0;
        while (!input.equals("Finish")) {
            String movie = input;
            int freeSeating = Integer.parseInt(scanner.nextLine());
            int seatTaken = 0;

            for (int i = 1; i <= freeSeating; i++) {
                String seatingType = scanner.nextLine();

                if (seatingType.equals("End")) {
                    break;
                } else if (seatingType.equals("student")) {
                    studentSeating++;
                } else if (seatingType.equals("standard")) {
                    standardSeating++;
                } else if (seatingType.equals("kid")) {
                    kidSeating++;
                }
                seatTaken++;
            }
            System.out.printf("%s - %.2f%% full.%n", movie, (seatTaken * 1.0 / freeSeating) * 100);

            input = scanner.nextLine();
        }
        int allTickets = studentSeating + standardSeating + kidSeating;
        System.out.printf("Total tickets: %d%n", allTickets);
        System.out.printf("%.2f%% student tickets.%n", studentSeating * 1.0 / allTickets * 100);
        System.out.printf("%.2f%% standard tickets.%n", standardSeating * 1.0 / allTickets * 100);
        System.out.printf("%.2f%% kids tickets.%n", kidSeating * 1.0 / allTickets * 100);


    }
}
